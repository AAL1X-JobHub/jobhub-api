package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.JobDto;
import com.al1x.jobhub.dto.JobUpdateDto;
import com.al1x.jobhub.model.entity.Job;
import java.util.List;

public interface JobService {
    // Another Functions
    List<Job> readJobs();

    // CRUD
    void createJob(JobDto jobDto);
    Job readJob(Integer id);
    void updateJob(Integer id, JobUpdateDto jobUpdateDtoDto);
    void deleteJob(Integer id);

    // US 20
    List<Job> searchJobs(String jobType, String location, Double minSalary, Double maxSalary);
    List<Job> searchByJobType(String jobType);
    List<Job> searchByLocation(String location);
    List<Job> searchByMaxSalary(Double maxSalary);
    List<Job> searchByMinSalary(Double minSalary);
}