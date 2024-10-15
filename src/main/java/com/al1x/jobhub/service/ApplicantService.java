package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.dto.ApplicantUpdateDto;

public interface ApplicantService {
    ApplicantDetailsDto createProfile(ApplicantDto applicantDto);
    Applicant readProfile(Integer id);
    Applicant updateProfile(Integer applicantId, ApplicantUpdateDto profileUpdateDto);

    Applicant addCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto);
    Applicant addInformationToProfile(Integer applicantId, ApplicantUpdateDto profileUpdateDto);
}