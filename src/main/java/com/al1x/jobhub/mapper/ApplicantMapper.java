package com.al1x.jobhub.mapper;

import com.al1x.jobhub.domain.entity.Applicant;
import com.al1x.jobhub.dto.ApplicantDetailsDTO;
import com.al1x.jobhub.dto.ApplicantDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ApplicantMapper {
    private final ModelMapper modelMapper;

    public ApplicantDetailsDTO toApplicantDetailsDTO(Applicant applicant) { return modelMapper.map(applicant, ApplicantDetailsDTO.class); }
    public Applicant toApplicant(ApplicantDetailsDTO applicantDetailsDTO) { return modelMapper.map(applicantDetailsDTO, Applicant.class); }
    public Applicant toApplicant(ApplicantDTO applicantDTO) { return modelMapper.map(applicantDTO, Applicant.class); }
}