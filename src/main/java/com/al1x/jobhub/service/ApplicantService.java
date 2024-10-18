package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Application;

import java.util.List;

public interface ApplicantService {
    // Another Functions
    List<Applicant> readApplicants();
    List<Application> readApplicationHistory(Integer id);

    // CRUD
    void createApplicant(ApplicantDTO applicantDto);
    Applicant readApplicant(Integer id);
    void updateApplicant(Integer applicantId, ApplicantUpdateDTO profileUpdateDto);
    void deleteApplicant(Integer applicantId);

    // US 14
    void addApplicantCurriculum(Integer applicantId, CurriculumUpdateDTO curriculumUpdateDto);
    // US 15
    void addApplicantInformation(Integer applicantId, ApplicantUpdateDTO profileUpdateDto);
    // US 19
    ApplicantJobRecommendedDTO recommendedJobs(Integer applicantId);
    ApplicantJobRecommendedDTO recommendedByTitle(Integer applicantId);
    ApplicantJobRecommendedDTO recommendedByLocation(Integer applicantId);
    void applicationJob(Integer id, Integer jobId);
}