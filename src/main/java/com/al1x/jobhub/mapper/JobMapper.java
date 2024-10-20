package com.al1x.jobhub.mapper;

import com.al1x.jobhub.domain.entity.Job;
import com.al1x.jobhub.dto.JobDetailsDTO;
import com.al1x.jobhub.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobMapper {
    private final ModelMapper modelMapper;

    public JobDetailsDTO toJobDetailsDto(Job job) { return modelMapper.map(job, JobDetailsDTO.class); }
    public Job toJob(JobDetailsDTO jobDetailsDto) { return modelMapper.map(jobDetailsDto, Job.class); }
    public Job toJob(JobDTO jobDto) { return modelMapper.map(jobDto, Job.class); }
}