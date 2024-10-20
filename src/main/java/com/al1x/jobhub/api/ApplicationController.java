package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.ApplicationDTO;
import com.al1x.jobhub.dto.ApplicationDetailsDTO;
import com.al1x.jobhub.service.ApplicantService;
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
    private final ApplicantService applicantService;

    // CRUD
    @PostMapping("/create")
    public ResponseEntity<ApplicationDetailsDTO> createApplication(@RequestBody ApplicationDTO applicationDto) {
        return new ResponseEntity<>(applicationService.createApplication(applicationDto), HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<List<ApplicationDetailsDTO>> readApplications(@RequestParam(name = "applicantId", required = false) Integer applicantId){
        return new ResponseEntity<>(applicantService.readApplicationHistory(applicantId), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable("id")Integer id, @RequestBody ApplicationDTO applicationDto) {
        applicationService.updateApplication(id, applicationDto);
        return new ResponseEntity<>("La postulación fue modificada correctamente", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable("id")Integer id) {
        applicationService.deleteApplication(id);
        return new ResponseEntity<>("La postulación fue eliminada correctamente", HttpStatus.OK);
    }
}