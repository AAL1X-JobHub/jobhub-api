package com.al1x.jobhub.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationDetailsDto {
    private LocalDate dateCreated;
    private Integer jobId;
    private Integer applicantId;
}