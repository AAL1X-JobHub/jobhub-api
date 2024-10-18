package com.al1x.jobhub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailsDTO {
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Double salaryRange;
}