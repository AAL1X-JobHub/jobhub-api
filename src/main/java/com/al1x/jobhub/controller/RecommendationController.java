package com.al1x.jobhub.controller;

import com.al1x.jobhub.dto.RecommendationDto;
import com.al1x.jobhub.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{applicantId}")
    public RecommendationDto getRecommendations(@PathVariable Integer applicantId) {
        return recommendationService.getRecommendations(applicantId);
    }
}
