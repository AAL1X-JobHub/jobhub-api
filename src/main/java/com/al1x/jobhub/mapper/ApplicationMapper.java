package com.al1x.jobhub.mapper;

import com.al1x.jobhub.dto.ApplicationDetailsDto;
import com.al1x.jobhub.dto.ApplicationDto;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.model.entity.Job;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ApplicationMapper {
    private final ModelMapper modelMapper;

    public ApplicationDetailsDto toApplicationDetailsDto(Application application) { return modelMapper.map(application, ApplicationDetailsDto.class); }
    public Application toApplication(ApplicationDetailsDto applicationDetailsDto) { return modelMapper.map(applicationDetailsDto, Application.class); }
    public Application toApplication(ApplicationDto applicationDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(ApplicationDto.class, Application.class).addMappings(mapper -> {
                    mapper.map(ApplicationDto::getApplicantId, (dest, v) -> dest.setApplicant(new Applicant((Integer) v)));
                    mapper.map(ApplicationDto::getJobId, (dest, v) -> dest.setJob(new Job((Integer) v)));
                });

        return modelMapper.map(applicationDto, Application.class);
    }
}