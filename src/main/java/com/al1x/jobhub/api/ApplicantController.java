package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.service.ApplicantService;
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

    // Another Functions
    @GetMapping("/read")
    public ResponseEntity<List<Applicant>> readApplicants(){
        return new ResponseEntity<>(applicantService.readApplicants(), HttpStatus.FOUND);
    }
    @GetMapping("/{id}/applicationHistory")
    public ResponseEntity<List<Application>> getApplicationHistory(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.readApplicationHistory(id), HttpStatus.FOUND);
    }

    // CRUD
    @PostMapping("/create")
    public ResponseEntity<String> createApplicant(@RequestBody ApplicantDto applicantDto) {
        applicantService.createApplicant(applicantDto);
        return new ResponseEntity<>("El perfil fue creado correctamente", HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Applicant> readApplicant(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.readApplicant(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateApplicant(@PathVariable("id") Integer id, @RequestBody ApplicantUpdateDto applicantUpdateDto) {
        applicantService.updateApplicant(id, applicantUpdateDto);
        return new ResponseEntity<>("El perfil fue modificado correctamente", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable("id") Integer id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>("El perfil fue eliminado correctamente", HttpStatus.OK);
    }

    // US 14
    @PostMapping("/{id}/addCurriculum")
    public ResponseEntity<String> addApplicantCurriculum(@PathVariable("id") Integer id, @RequestBody CurriculumUpdateDto curriculumUpdateDto) {
        applicantService.addApplicantCurriculum(id, curriculumUpdateDto);
        return new ResponseEntity<>("El curriculum fue agregado correctamente", HttpStatus.ACCEPTED);
    }
    // US 15
    @PutMapping("/{id}/addInfomation")
    public ResponseEntity<String> addInformationToProfile(@PathVariable("id") Integer id, @RequestBody ApplicantUpdateDto applicantUpdateDto) {
        applicantService.addApplicantInformation(id, applicantUpdateDto);
        return new ResponseEntity<>("La información fue agregada correctamente", HttpStatus.ACCEPTED);
    }
    // US 19
    @GetMapping("/{id}/jobsRecommended")
    public ResponseEntity<ApplicantJobRecommendedDto> recommendedJobs(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedJobs(id), HttpStatus.FOUND);
    }
    @GetMapping("/{id}/jobsRecommended/title")
    public ResponseEntity<ApplicantJobRecommendedDto> recommendedByTitle(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedByTitle(id), HttpStatus.FOUND);
    }
    @GetMapping("/{id}/jobsRecommended/location")
    public ResponseEntity<ApplicantJobRecommendedDto> recommendedByLocation(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicantService.recommendedByLocation(id), HttpStatus.FOUND);
    }

    // US 18
    @PostMapping("/{id}/applicationJob")
    public ResponseEntity<String> applicationJob(@PathVariable("id") Integer id, @RequestParam(name = "jobId", required = false) Integer jobId) {
        applicantService.applicationJob(id, jobId);
        return new ResponseEntity<>("La postulación fue creada correctamente", HttpStatus.CREATED);
    }
}