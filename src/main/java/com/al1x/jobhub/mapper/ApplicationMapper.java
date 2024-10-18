package com.al1x.jobhub.mapper;

import com.al1x.jobhub.dto.ApplicationDetailsDTO;
import com.al1x.jobhub.dto.ApplicationDTO;
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

    public ApplicationDetailsDTO toApplicationDetailsDto(Application application) { return modelMapper.map(application, ApplicationDetailsDTO.class); }
    public Application toApplication(ApplicationDetailsDTO applicationDetailsDto) { return modelMapper.map(applicationDetailsDto, Application.class); }
    public Application toApplication(ApplicationDTO applicationDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(ApplicationDTO.class, Application.class).addMappings(mapper -> {
                    mapper.map(ApplicationDTO::getApplicantId, (dest, v) -> dest.setApplicant(new Applicant((Integer) v)));
                    mapper.map(ApplicationDTO::getJobId, (dest, v) -> dest.setJob(new Job((Integer) v)));
                });

        return modelMapper.map(applicationDto, Application.class);
    }
}