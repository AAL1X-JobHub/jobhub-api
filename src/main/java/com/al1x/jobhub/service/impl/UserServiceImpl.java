package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.UserDetailsDTO;
import com.al1x.jobhub.dto.UserDTO;
import com.al1x.jobhub.dto.UserLoginDTO;
import com.al1x.jobhub.dto.UserLoginResponseDTO;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.ApplicantMapper;
import com.al1x.jobhub.mapper.UserMapper;
import com.al1x.jobhub.domain.entity.Role;
import com.al1x.jobhub.domain.entity.User;
import com.al1x.jobhub.domain.enums.ERole;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.RoleRepository;
import com.al1x.jobhub.repository.UserRepository;
import com.al1x.jobhub.security.TokenProvider;
import com.al1x.jobhub.security.UserPrincipal;
import com.al1x.jobhub.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    // Another Functions
    @Override
    public List<UserDetailsDTO> readUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDetailsDto).collect(Collectors.toList());
    }

    // CRUD
    // US 01
    @Transactional
    @Override
    public UserDetailsDTO createUser(UserDTO userDto, ERole eRole) {
        User user = userMapper.toUser(userDto);

        user.setRole(roleRepository.findByName(eRole).get());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setDateCreate(LocalDate.now());
        user.setActiveAccount(false);
        user.setApplicant(null);

        userRepository.save(user);

        return userMapper.toUserDetailsDto(user);
    }
    @Override
    public UserDetailsDTO readUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + id + " no fue encontrado"));

        if (!user.getActiveAccount()) {
            throw new IllegalStateException("No hay sesión activa para este usuario");
        }

        return userMapper.toUserDetailsDto(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + id + " no fue encontrado")));
    }
    @Transactional
    @Override
    public UserDetailsDTO updateUser(Integer id, UserDTO userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + id + " no fue encontrado"));

        if (!user.getActiveAccount()) {
            throw new IllegalStateException("No hay sesión activa para este usuario");
        }

        user.setRole(new Role(1, ERole.USER));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User userDetailsDto = userRepository.save(user);
        return userMapper.toUserDetailsDto(userDetailsDto);
    }
    // US 05
    @Transactional
    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + id + " no fue encontrado"));

        if (!user.getActiveAccount()) {
            throw new IllegalStateException("No hay sesión activa para este usuario");
        }

        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + id + " no fue encontrado")));
    }

    // US 02
    @Override
    public UserLoginResponseDTO logIn(UserLoginDTO userLoginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        UserDetailsDTO userDetailsDTO = userMapper.toUserDetailsDto(userPrincipal.getUser());

        //boolean isAdmin = userDetailsDTO.getRoleName().equals("ADMIN");

        String token = tokenProvider.createAccessToken(authentication);

        UserLoginResponseDTO userLoginResponseDto = new UserLoginResponseDTO();
        userLoginResponseDto.setToken(token);
        userLoginResponseDto.setApplicantDetailsDto(applicantMapper.toApplicantDetailsDTO(applicantRepository.findByEmail(userLoginDTO.getEmail())));

        Optional<User> user = userRepository.findByEmail(userLoginDTO.getEmail());
        user.get().setActiveAccount(true);

        return userLoginResponseDto;
    }
    // US 04
    @Override
    public void logOut(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (!user.get().getActiveAccount()) {
            throw new IllegalStateException("No hay sesión activa para este usuario");
        }

        user.get().setActiveAccount(false);
    }
}