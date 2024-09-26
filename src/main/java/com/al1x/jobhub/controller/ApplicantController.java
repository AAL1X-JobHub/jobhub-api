package com.al1x.jobhub.controller;

import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.domain.Applicant;
import com.al1x.jobhub.dto.ProfileUpdateDto;
import com.al1x.jobhub.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<Applicant> crearPerfil(@RequestBody ApplicantDto applicantDto) {
        Applicant applicant = applicantService.crearPerfil(applicantDto);
        return ResponseEntity.ok(applicant);
    }

    @PostMapping("/{applicantId}/curriculum")
    public ResponseEntity<Applicant> adherirCurriculum(@PathVariable Integer applicantId, @RequestBody CurriculumUpdateDto curriculumUpdateDto) {
        Applicant updatedApplicant = applicantService.adherirCurriculum(applicantId, curriculumUpdateDto);
        return ResponseEntity.ok(updatedApplicant);
    }

    @PostMapping("/{applicantId}/profile-info")
    public ResponseEntity<Void> agregarInformacionAlPerfil(@PathVariable Integer applicantId,
                                                           @RequestBody ProfileUpdateDto profileUpdateDto) {
        applicantService.agregarInformacionAlPerfil(applicantId, profileUpdateDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable("id") Integer applicantId,
                                                @RequestBody ProfileUpdateDto profileUpdateDto) {
        applicantService.modificarPerfil(applicantId, profileUpdateDto);
        return ResponseEntity.ok("El perfil a sido modificado correctamente");
    }
}
