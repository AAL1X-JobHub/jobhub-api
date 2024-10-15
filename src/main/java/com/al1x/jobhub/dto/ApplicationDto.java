package com.al1x.jobhub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationDto {
    private Integer jobId;
    private Integer applicantId;

    public ApplicationDto(Integer jobId, Integer applicantId) {
        this.jobId = jobId;
        this.applicantId = applicantId;
    }
}