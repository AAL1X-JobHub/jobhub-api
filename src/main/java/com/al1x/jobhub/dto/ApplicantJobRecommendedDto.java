package com.al1x.jobhub.dto;

import com.al1x.jobhub.model.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantJobRecommendedDto {
    private Integer applicantId;
    private List<Integer> recommendedJobIds;
    private List<Job> recommendedJobs;
}