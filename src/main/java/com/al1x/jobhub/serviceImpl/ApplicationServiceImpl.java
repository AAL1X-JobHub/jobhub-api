package com.al1x.jobhub.serviceImpl;

import com.al1x.jobhub.dto.ApplicationDto;
import com.al1x.jobhub.domain.Application;
import com.al1x.jobhub.domain.Applicant;
import com.al1x.jobhub.domain.Job;
import com.al1x.jobhub.repository.ApplicationRepository;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Application postulacionEmpleo(ApplicationDto applicationDto) {
        Job job = jobRepository.findById(applicationDto.getJobId())
                .orElseThrow(() -> new RuntimeException("Trabajo no encontrado"));

        Applicant applicant = applicantRepository.findById(applicationDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado"));

        Application application = new Application();
        application.setJob(job);
        application.setApplicant(applicant);
        application.setDateCreated(LocalDate.now());

        return applicationRepository.save(application);
    }
}