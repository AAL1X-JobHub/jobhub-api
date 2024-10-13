package com.al1x.jobhub.dto;

import com.al1x.jobhub.model.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFilterDto {
    private String jobType;
    private String location;
    private Double minSalary;
    private Double maxSalary;

    public Job toJobEntity() {
        Job job = new Job();
        job.setJobType(this.jobType);
        job.setLocation(this.location);
        job.setSalaryRange(this.minSalary);
        job.setSalaryRange(this.maxSalary);
        return job;
    }
}
