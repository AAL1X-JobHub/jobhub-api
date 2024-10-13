package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicationDetailsDto;
import com.al1x.jobhub.dto.ApplicationDto;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDetailsDto> applyForJob(@RequestBody ApplicationDto applicationDto) {
        ApplicationDetailsDto applicationDetailsDto = applicationService.EmploymentApplication(applicationDto);
        return new ResponseEntity<>(applicationDetailsDto, HttpStatus.CREATED);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<List<Application>> getApplicationHistory(@PathVariable Integer id) {
        List<Application> applications = applicationService.getApplicationHistory(id);
        return ResponseEntity.ok(applications);
    }
}