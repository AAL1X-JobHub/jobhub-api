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
    private String description;
    private String country;
}