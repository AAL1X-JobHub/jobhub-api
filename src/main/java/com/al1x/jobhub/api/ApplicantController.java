package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.dto.ApplicantUpdateDto;
import com.al1x.jobhub.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @PostMapping("/create")
    public ResponseEntity<ApplicantDetailsDto> createProfile(@RequestBody ApplicantDto applicantDto) {
        ApplicantDetailsDto applicantDetailsDto = applicantService.createProfile(applicantDto);
        return new ResponseEntity<>(applicantDetailsDto, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Applicant> readApplicant(@PathVariable Integer id) {
        Applicant applicant = applicantService.readProfile(id);
        return applicant != null ? ResponseEntity.ok(applicant) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateApplicant(@PathVariable("id") Integer applicantId, @RequestBody ApplicantUpdateDto profileUpdateDto) {
        applicantService.updateProfile(applicantId, profileUpdateDto);
        return ResponseEntity.ok("El perfil a sido modificado correctamente");
    }

    @PostMapping("/{id}/add-curriculum")
    public ResponseEntity<Applicant> addCurriculum(@PathVariable Integer applicantId, @RequestBody CurriculumUpdateDto curriculumUpdateDto) {
        Applicant updatedApplicant = applicantService.addCurriculum(applicantId, curriculumUpdateDto);
        return ResponseEntity.ok(updatedApplicant);
    }

    @PutMapping("/{id}/add-infoProfile")
    public ResponseEntity<String> addInformationToProfile(@PathVariable("id") Integer applicantId, @RequestBody ApplicantUpdateDto profileUpdateDto) {
        applicantService.addInformationToProfile(applicantId, profileUpdateDto);
        return ResponseEntity.ok("El perfil a sido modificado correctamente");
    }
}
