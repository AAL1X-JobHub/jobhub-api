package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.RecommendationDto;

public interface RecommendationService {
    RecommendationDto getRecommendations(Integer applicantId);
}