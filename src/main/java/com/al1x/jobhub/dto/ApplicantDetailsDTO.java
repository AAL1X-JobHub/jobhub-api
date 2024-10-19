package com.al1x.jobhub.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDetailsDTO {
    private String firstName;
    private String lastName;
    private String degree;
    private String country;
    private String email;
    private String phone;
    private String curriculumPath;
    private String experience;
    private String education;
}