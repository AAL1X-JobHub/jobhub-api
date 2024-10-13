package com.al1x.jobhub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateDto {
    private String firstName;
    private String lastName;
    private String degree;
    private String description;
    private String country;
    private String college;
    private String email;
    private String phone;
    private String experience;
    private String education;
}
