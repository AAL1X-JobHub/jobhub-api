package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.JobDTO;
import com.al1x.jobhub.dto.JobDetailsDTO;
import com.al1x.jobhub.dto.JobUpdateDTO;

import java.util.List;

public interface JobService {
    // Another Functions
    List<JobDetailsDTO> readJobs();

    // CRUD
    void createJob(JobDTO jobDto);
    JobDetailsDTO readJob(Integer id);
    void updateJob(Integer id, JobUpdateDTO jobUpdateDtoDto);
    void deleteJob(Integer id);

    // US 20
    List<JobDetailsDTO> searchJobs(String jobType, String location, Double minSalary, Double maxSalary);
    List<JobDetailsDTO> searchByJobType(String jobType);
    List<JobDetailsDTO> searchByLocation(String location);
    List<JobDetailsDTO> searchByMaxSalary(Double maxSalary);
    List<JobDetailsDTO> searchByMinSalary(Double minSalary);
}