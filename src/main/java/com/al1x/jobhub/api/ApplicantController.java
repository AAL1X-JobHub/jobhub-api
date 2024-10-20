package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.service.ApplicantService;
import com.al1x.jobhub.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;
    private final ApplicationService applicationService;

    // Another Functions
    @GetMapping("/read")
    public ResponseEntity<List<ApplicantDetailsDTO>> readApplicants(){
        return new ResponseEntity<>(applicantService.readApplicants(), HttpStatus.FOUND);
    }

    // CRUD
    @PostMapping("/create")
    public ResponseEntity<ApplicantDetailsDTO> createApplicant(@RequestBody ApplicantDTO applicantDto) {
        return new ResponseEntity<>(applicantService.createApplicant(applicantDto), HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<ApplicantDetailsDTO> readApplicant(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.readApplicant(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApplicantDetailsDTO> updateApplicant(@PathVariable("id") Integer id, @RequestBody ApplicantUpdateDTO profileUpdateDto) {
        return new ResponseEntity<>(applicantService.updateApplicant(id, profileUpdateDto), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable("id") Integer id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>("El perfil fue eliminado correctamente", HttpStatus.OK);
    }

    // US 14
    @PutMapping("/{id}/addCurriculum")
    public ResponseEntity<ApplicantDetailsDTO> addApplicantCurriculum(@PathVariable("id") Integer id, @RequestBody ApplicantCurriculumUpdateDTO curriculumUpdateDto) {
        return new ResponseEntity<>(applicantService.addApplicantCurriculum(id, curriculumUpdateDto), HttpStatus.ACCEPTED);
    }
    // US 15
    @PutMapping("/{id}/addInformation")
    public ResponseEntity<ApplicantDetailsDTO> addInformationToProfile(@PathVariable("id") Integer id, @RequestBody ApplicantInformationUpdateDTO applicantInformationUpdateDTO) {
        return new ResponseEntity<>(applicantService.addApplicantInformation(id, applicantInformationUpdateDTO), HttpStatus.ACCEPTED);
    }
    // US 19
    @GetMapping("/{id}/jobsRecommended")
    public ResponseEntity<JobRecommendedDTO> recommendedJobs(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedJobs(id), HttpStatus.FOUND);
    }
    @GetMapping("/{id}/jobsRecommended/title")
    public ResponseEntity<JobRecommendedDTO> recommendedByTitle(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedByTitle(id), HttpStatus.FOUND);
    }
    @GetMapping("/{id}/jobsRecommended/location")
    public ResponseEntity<JobRecommendedDTO> recommendedByLocation(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedByLocation(id), HttpStatus.FOUND);
    }

    // US 18
    @PostMapping("/{id}/applicationJob")
    public ResponseEntity<ApplicationDetailsDTO> applicationJob(@PathVariable("id") Integer id, @RequestParam(name = "jobId", required = false) Integer jobId) {
        return new ResponseEntity<>(applicationService.applicationJob(id, jobId), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/applicationHistory")
    public ResponseEntity<List<ApplicationDetailsDTO>> getApplicationHistory(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.readApplicationHistory(id), HttpStatus.FOUND);
    }
}
