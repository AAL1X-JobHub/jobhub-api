package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.ApplicationDTO;
import com.al1x.jobhub.dto.ApplicationDetailsDTO;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.ApplicantMapper;
import com.al1x.jobhub.mapper.ApplicationMapper;
import com.al1x.jobhub.domain.entity.Application;
import com.al1x.jobhub.domain.entity.Applicant;
import com.al1x.jobhub.domain.entity.Job;
import com.al1x.jobhub.repository.ApplicationRepository;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final ApplicantRepository applicantRepository;
    private final ApplicationMapper applicationMapper;

    // Another Functions


    // CRUD
    @Transactional
    @Override
    public ApplicationDetailsDTO createApplication(ApplicationDTO applicationDto) {
        Application application = applicationMapper.toApplication(applicationDto);

        Job job = jobRepository.findById(applicationDto.getJobId()).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + applicationDto.getJobId() + " no fue encontrado"));
        Applicant applicant = applicantRepository.findById(applicationDto.getApplicantId()).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + applicationDto.getApplicantId() + " no fue encontrado"));

        application.setDateCreated(LocalDate.now());
        application.setJob(job);
        application.setApplicant(applicant);

        return applicationMapper.toApplicationDetailsDto(applicationRepository.save(application));
    }

    @Transactional
    @Override
    public void updateApplication(Integer id, ApplicationDTO applicationDto) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La postulación con ID " + id + " no fue encontrada"));

        Job job = jobRepository.findById(applicationDto.getJobId()).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + applicationDto.getJobId() + " no fue encontrado"));
        Applicant applicant = applicantRepository.findById(applicationDto.getApplicantId()).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + applicationDto.getApplicantId() + " no fue encontrado"));

        application.setJob(job);
        application.setApplicant(applicant);

        applicationRepository.save(application);
    }

    @Transactional
    @Override
    public void deleteApplication(Integer id) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La postulación con ID " + id + " no fue encontrada"));
        applicationRepository.delete(application);
    }

    // US 18
    @Transactional
    @Override
    public ApplicationDetailsDTO applicationJob(Integer id, Integer jobId) {
        Application application = new Application();

        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + jobId + " no fue encontrado"));
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        application.setDateCreated(LocalDate.now());
        application.setJob(job);
        application.setApplicant(applicant);

        return applicationMapper.toApplicationDetailsDto(applicationRepository.save(application));
    }
}