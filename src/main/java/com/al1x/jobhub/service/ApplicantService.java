package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.domain.Applicant;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.dto.ProfileUpdateDto;

public interface ApplicantService {
    Applicant crearPerfil(ApplicantDto applicantDto);
    Applicant adherirCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto);
    Applicant agregarInformacionAlPerfil(Integer applicantId, ProfileUpdateDto profileUpdateDto);
    Applicant modificarPerfil(Integer applicantId, ProfileUpdateDto profileUpdateDto);
}