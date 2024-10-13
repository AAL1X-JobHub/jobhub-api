package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.RecommendationDto;
import com.al1x.jobhub.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/{id}")
    public RecommendationDto getRecommendations(@PathVariable Integer id) {
        return recommendationService.getRecommendations(id);
    }
}
