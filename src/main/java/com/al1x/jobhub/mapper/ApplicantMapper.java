package com.al1x.jobhub.mapper;

import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicantDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ApplicantMapper {
    private final ModelMapper modelMapper;

    public ApplicantDetailsDto toApplicantDetailsDto(Applicant applicant) { return modelMapper.map(applicant, ApplicantDetailsDto.class); }

    public Applicant toApplicant(ApplicantDetailsDto applicantDetailsDto) { return modelMapper.map(applicantDetailsDto, Applicant.class); }

    public Applicant toApplicant(ApplicantDto applicantDto) { return modelMapper.map(applicantDto, Applicant.class); }
}