package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.JobDetailsDto;
import com.al1x.jobhub.dto.JobDto;
import com.al1x.jobhub.dto.JobUpdateDto;
import com.al1x.jobhub.model.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> listJobs();
    Job getJobById(Integer id);
    List<Job> filterJobs(String jobType, String location, Double minSalary, Double maxSalary);
    List<Job> filterByJobType(String jobType);
    List<Job> filterByLocation(String location);
    List<Job> filterByMaxSalary(Double maxSalary);
    List<Job> filterByMinSalary(Double minSalary);

    JobDetailsDto createJob(JobDto jobDto);
    Job updateJob(Integer id, JobUpdateDto jobUpdateDtoDto);
    void deleteJob(Integer id);
}