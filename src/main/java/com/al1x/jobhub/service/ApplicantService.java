package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.model.entity.Application;

import java.util.List;

public interface ApplicantService {
    // Another Functions
    List<ApplicantDetailsDTO> readApplicants();
    List<ApplicationDetailsDTO> readApplicationHistory(Integer id);

    // CRUD
    ApplicantDetailsDTO createApplicant(ApplicantDTO applicantDto);
    ApplicantDetailsDTO readApplicant(Integer id);
    ApplicantDetailsDTO updateApplicant(Integer applicantId, ApplicantUpdateDTO profileUpdateDto);
    void deleteApplicant(Integer applicantId);

    // US 14
    ApplicantDetailsDTO addApplicantCurriculum(Integer id, ApplicantCurriculumUpdateDTO curriculumUpdateDto);
    // US 15
    ApplicantDetailsDTO addApplicantInformation(Integer id, ApplicantInformationUpdateDTO applicantInformationUpdateDTO);
    // US 19
    JobRecommendedDTO recommendedJobs(Integer applicantId);
    JobRecommendedDTO recommendedByTitle(Integer applicantId);
    JobRecommendedDTO recommendedByLocation(Integer applicantId);

}