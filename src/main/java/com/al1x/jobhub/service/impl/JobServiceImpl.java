package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.model.entity.Company;
import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.dto.JobDTO;
import com.al1x.jobhub.dto.JobUpdateDTO;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.JobMapper;
import com.al1x.jobhub.repository.CompanyRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final JobMapper jobMapper;

    // Another Functions
    @Override
    public List<Job> readJobs() {
        return jobRepository.findAll();
    }

    // CRUD
    @Transactional
    @Override
    public void createJob(JobDTO jobDto) {
        Job job = jobMapper.toJob(jobDto);

        Company company = companyRepository.findById(jobDto.getCompany_id()).orElseThrow(() -> new ResourceNotFoundException("La compañia con ID " + jobDto.getCompany_id() + " no fue encontrada"));

        job.setTitle(job.getTitle());
        job.setDescription(job.getDescription());
        job.setLocation(jobDto.getLocation());
        job.setJobType(jobDto.getJobType());
        job.setPostedDate(jobDto.getPostedDate());
        job.setExpirationDate(jobDto.getExpirationDate());
        job.setSalaryRange(jobDto.getSalaryRange());
        job.setCompany(company);

        jobRepository.save(job);
    }
    @Override
    public Job readJob(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + id + " no fue encontrado"));
        return job;
    }
    @Transactional
    @Override
    public void updateJob(Integer id, JobUpdateDTO jobUpdateDto) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + id + " no fue encontrado"));

        job.setTitle(jobUpdateDto.getTitle());
        job.setDescription(jobUpdateDto.getDescription());
        job.setLocation(jobUpdateDto.getLocation());
        job.setJobType(jobUpdateDto.getJobType());
        job.setExpirationDate(jobUpdateDto.getExpirationDate());
        job.setSalaryRange(jobUpdateDto.getSalaryRange());

        jobRepository.save(job);
    }
    @Transactional
    @Override
    public void deleteJob(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + id + " no fue encontrado"));
        jobRepository.delete(job);
    }

    // US 20
    @Override
    public List<Job> searchJobs(String jobType, String location, Double minSalary, Double maxSalary) { return jobRepository.searchJobs(jobType, location, minSalary, maxSalary); }
    @Override
    public List<Job> searchByJobType(String jobType) {
        return jobRepository.searchByJobType(jobType);
    }
    @Override
    public List<Job> searchByLocation(String location) {
        return jobRepository.searchByLocation(location);
    }
    @Override
    public List<Job> searchByMaxSalary(Double maxSalary) {
        return jobRepository.searchByMaxSalary(maxSalary);
    }
    @Override
    public List<Job> searchByMinSalary(Double minSalary) {
        return jobRepository.searchByMinSalary(minSalary);
    }
}