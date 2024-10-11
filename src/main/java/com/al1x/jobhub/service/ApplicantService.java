package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.dto.ProfileUpdateDto;

public interface ApplicantService {
    ApplicantDetailsDto createProfile(ApplicantDto applicantDto);
    Applicant findById(Integer id);
    Applicant addCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto);
    Applicant addInformationToProfile(Integer applicantId, ProfileUpdateDto profileUpdateDto);
    Applicant updateProfile(Integer applicantId, ProfileUpdateDto profileUpdateDto);
}