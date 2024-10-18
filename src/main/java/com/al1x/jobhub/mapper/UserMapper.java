package com.al1x.jobhub.mapper;

import com.al1x.jobhub.dto.UserDTO;
import com.al1x.jobhub.dto.UserDetailsDTO;
import com.al1x.jobhub.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserDetailsDTO toUserDetailsDto(User user) { return modelMapper.map(user, UserDetailsDTO.class); }
    public User toUser(UserDetailsDTO userDetailsDto) { return modelMapper.map(userDetailsDto, User.class); }
    public User toUser(UserDTO userDto) { return modelMapper.map(userDto, User.class); }
}