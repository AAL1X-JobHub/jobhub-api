package com.al1x.jobhub.dto;

import lombok.Data;

@Data
public class JobDetailsDto {
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Double salaryRange;
}
