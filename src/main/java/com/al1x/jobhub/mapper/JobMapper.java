package com.al1x.jobhub.mapper;

import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.dto.JobDetailsDto;
import com.al1x.jobhub.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobMapper {
    private final ModelMapper modelMapper;

    public JobDetailsDto toJobDetailsDto(Job job) { return modelMapper.map(job, JobDetailsDto.class); }

    public Job toJob(JobDetailsDto jobDetailsDto) { return modelMapper.map(jobDetailsDto, Job.class); }

    public Job toJob(JobDto jobDto) { return modelMapper.map(jobDto, Job.class); }
}