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
    void createApplicant(ApplicantDto applicantDto);
    Applicant readApplicant(Integer id);
    void updateApplicant(Integer applicantId, ProfileUpdateDto profileUpdateDto);
    void deleteApplicant(Integer applicantId);

    // US 14
    void addApplicantCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto);
    // US 15
    void addApplicantInformation(Integer applicantId, ProfileUpdateDto profileUpdateDto);
    // US 19
    ApplicantJobRecommendedDto recommendedJobs(Integer applicantId);
    ApplicantJobRecommendedDto recommendedByTitle(Integer applicantId);
    ApplicantJobRecommendedDto recommendedByLocation(Integer applicantId);
    void applicationJob(Integer id, Integer jobId);
}