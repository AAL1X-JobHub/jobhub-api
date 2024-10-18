package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.JobDTO;
import com.al1x.jobhub.dto.JobUpdateDTO;
import com.al1x.jobhub.model.entity.Job;
import java.util.List;

public interface JobService {
    // Another Functions
    List<Job> readJobs();

    // CRUD
    void createJob(JobDTO jobDto);
    Job readJob(Integer id);
    void updateJob(Integer id, JobUpdateDTO jobUpdateDtoDto);
    void deleteJob(Integer id);

    // US 20
    List<Job> searchJobs(String jobType, String location, Double minSalary, Double maxSalary);
    List<Job> searchByJobType(String jobType);
    List<Job> searchByLocation(String location);
    List<Job> searchByMaxSalary(Double maxSalary);
    List<Job> searchByMinSalary(Double minSalary);
}