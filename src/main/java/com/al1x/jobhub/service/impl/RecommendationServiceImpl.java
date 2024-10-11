package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.RecommendationDto;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private JobRepository jobRepository;

    @Override
    public RecommendationDto getRecommendations(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found"));

        List<Job> recommendedJobs = jobRepository.findJobsByCriteria(applicant.getDegree(), applicant.getCountry());
        List<Integer> recommendedJobIds = recommendedJobs.stream().map(Job::getId).collect(Collectors.toList());

        RecommendationDto recommendationDto = new RecommendationDto();
        recommendationDto.setApplicantId(id);
        recommendationDto.setRecommendedJobIds(recommendedJobIds);
        recommendationDto.setRecommendedJobs(recommendedJobs);
        return recommendationDto;
    }
}
