package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.UserDetailsDTO;
import com.al1x.jobhub.dto.UserDTO;
import com.al1x.jobhub.dto.UserLoginDTO;
import com.al1x.jobhub.dto.UserLoginResponseDTO;
import com.al1x.jobhub.model.enums.ERole;

import java.util.List;

public interface UserService {
    // Another Functions
    List<UserDetailsDTO> readUsers();

    // CRUD
    // US 01
    UserDetailsDTO createUser(UserDTO userDto, ERole eRole);
    UserDetailsDTO readUser(Integer id);
    UserDetailsDTO updateUser(Integer id, UserDTO userDto);
    // US 05
    void deleteUser(Integer id);

    // US 02
    UserLoginResponseDTO logIn(UserLoginDTO userLoginDTO);
    // US 04
    void logOut(String email);
}
