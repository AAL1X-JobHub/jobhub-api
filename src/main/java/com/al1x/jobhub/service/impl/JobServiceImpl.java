package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.model.entity.Company;
import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.dto.JobDetailsDto;
import com.al1x.jobhub.dto.JobDto;
import com.al1x.jobhub.dto.JobUpdateDto;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.JobMapper;
import com.al1x.jobhub.repository.CompanyRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<Job> listJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo no encontrado con ID: "+ id));
        return job;
    }

    @Override
    public List<Job> filterJobs(String jobType, String location, Double minSalary, Double maxSalary) {
        return jobRepository.findJobsByFilters(
                jobType,
                location,
                minSalary,
                maxSalary
        );
    }

    @Override
    public List<Job> filterByJobType(String jobType) {
        return jobRepository.findJobsByJobType(jobType);
    }
    @Override
    public List<Job> filterByLocation(String location) {
        return jobRepository.findJobsByLocation(location);
    }
    @Override
    public List<Job> filterByMaxSalary(Double maxSalary) {
        return jobRepository.findJobsByMaxSalary(maxSalary);
    }
    @Override
    public List<Job> filterByMinSalary(Double minSalary) {
        return jobRepository.findJobsByMinSalary(minSalary);
    }

    @Transactional
    @Override
    public JobDetailsDto createJob(JobDto jobDto) {
        Job job = jobMapper.toJob(jobDto);

        Company company = companyRepository.findById(jobDto.getCompany_id()).orElseThrow(() -> new ResourceNotFoundException("Compañia no encontrada con ID: "+ jobDto.getCompany_id()));

        job.setTitle(job.getTitle());
        job.setDescription(job.getDescription());
        job.setLocation(jobDto.getLocation());
        job.setJobType(jobDto.getJobType());
        job.setPostedDate(jobDto.getPostedDate());
        job.setExpirationDate(jobDto.getExpirationDate());
        job.setSalaryRange(jobDto.getSalaryRange());
        job.setCompany(company);

        job = jobRepository.save(job);
        return jobMapper.toJobDetailsDto(job);
    }

    @Transactional
    @Override
    public Job updateJob(Integer id, JobUpdateDto jobUpdateDto) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("El trabajo con ID " + id + " no fue encontrada"));

        job.setTitle(jobUpdateDto.getTitle());
        job.setDescription(jobUpdateDto.getDescription());
        job.setLocation(jobUpdateDto.getLocation());
        job.setJobType(jobUpdateDto.getJobType());
        job.setExpirationDate(jobUpdateDto.getExpirationDate());
        job.setSalaryRange(jobUpdateDto.getSalaryRange());

        return jobRepository.save(job);
    }

    @Transactional
    @Override
    public void deleteJob(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + id + " no fue encontrada"));
        jobRepository.delete(job);
    }
}