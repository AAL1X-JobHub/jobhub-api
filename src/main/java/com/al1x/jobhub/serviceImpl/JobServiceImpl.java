package com.al1x.jobhub.serviceImpl;

import com.al1x.jobhub.dto.SearchFilterDto;
import com.al1x.jobhub.domain.Job;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> filterJobs(String jobType, String location,Double minSalary, Double maxSalary) {
        return jobRepository.findJobsByFilters(
                jobType,
                location,
                minSalary,
                maxSalary
        );
    }
}
