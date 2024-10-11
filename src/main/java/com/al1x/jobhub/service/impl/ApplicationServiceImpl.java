package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.ApplicationDetailsDto;
import com.al1x.jobhub.dto.ApplicationDto;
import com.al1x.jobhub.mapper.ApplicationMapper;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.repository.ApplicationRepository;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Transactional
    @Override
    public ApplicationDetailsDto EmploymentApplication(ApplicationDto applicationDto) {
        Application application = applicationMapper.toApplication(applicationDto);

        Job job = jobRepository.findById(applicationDto.getJobId()).orElseThrow(() -> new RuntimeException("Trabajo no encontrado"));
        Applicant applicant = applicantRepository.findById(applicationDto.getApplicantId()).orElseThrow(() -> new RuntimeException("Postulante no encontrado"));

        application.setDateCreated(LocalDate.now());
        application.setJob(job);
        application.setApplicant(applicant);

        application = applicationRepository.save(application);

        return applicationMapper.toApplicationDetailsDto(application);
    }

    @Override
    public List<Application> getApplicationHistory(Integer id) {
        return applicationRepository.findByApplicantId(id);
    }
}