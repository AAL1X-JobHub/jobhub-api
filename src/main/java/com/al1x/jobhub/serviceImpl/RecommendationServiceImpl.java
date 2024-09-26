package com.al1x.jobhub.serviceImpl;

import com.al1x.jobhub.dto.RecommendationDto;
import com.al1x.jobhub.domain.Applicant;
import com.al1x.jobhub.domain.Job;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public RecommendationDto getRecommendations(Integer applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        List<Job> recommendedJobs = jobRepository.findJobsByCriteria(applicant.getDegree(), applicant.getCountry());

        RecommendationDto recommendationDto = new RecommendationDto();
        recommendationDto.setRecommendedJobs(recommendedJobs);
        return recommendationDto;
    }
    
}
