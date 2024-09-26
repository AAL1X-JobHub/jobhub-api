package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.SearchFilterDto;
import com.al1x.jobhub.domain.Job;

import java.util.List;

public interface JobService {
    List<Job> filterJobs(String jobType, String location,Double minSalary, Double maxSalary);
}