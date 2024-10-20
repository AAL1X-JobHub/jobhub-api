package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.JobDetailsDTO;
import com.al1x.jobhub.dto.JobDTO;
import com.al1x.jobhub.dto.JobUpdateDTO;
import com.al1x.jobhub.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    // Another Functions
    @GetMapping("/read")
    public ResponseEntity<List<JobDetailsDTO>> getAllJobs(){
        return new ResponseEntity<>(jobService.readJobs(), HttpStatus.FOUND);
    }

    // CRUD
    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('COMPANY')")
    public ResponseEntity<String> createJob(@RequestBody JobDTO jobDto) {
        jobService.createJob(jobDto);
        return new ResponseEntity<>("El trabajo fue creado correctamente", HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<JobDetailsDTO> readJob(@PathVariable("id") Integer id){
        return new ResponseEntity<>(jobService.readJob(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('COMPANY')")
    public ResponseEntity<String> modifyJob(@PathVariable("id") Integer id, @RequestBody JobUpdateDTO jobUpdateDto) {
        jobService.updateJob(id, jobUpdateDto);
        return new ResponseEntity<>("El trabajo fue modificado correctamente", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('COMPANY')")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Integer id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>("El trabajo fue eliminado correctamente", HttpStatus.OK);
    }

    // US 20
    @GetMapping("/search")
    public ResponseEntity<List<JobDetailsDTO>> searchJobsByFilters(@RequestParam(name = "jobType", required = false) String jobType,
                                         @RequestParam(name = "location", required = false) String location,
                                         @RequestParam(name = "maxSalary", required = false) Double maxSalary,
                                         @RequestParam(name = "minSalary", required = false) Double minSalary) {
        return new ResponseEntity<>(jobService.searchJobs(jobType, location, maxSalary, minSalary), HttpStatus.FOUND);
    }
    @GetMapping("/search/type")
    public ResponseEntity<List<JobDetailsDTO>> searchJobsByType(@RequestParam(name = "jobType", required = false) String jobType) {
        return new ResponseEntity<>(jobService.searchByJobType(jobType), HttpStatus.FOUND);
    }
    @GetMapping("/search/location")
    public ResponseEntity<List<JobDetailsDTO>> searchJobsByLocation(@RequestParam(name = "location", required = false) String location) {
        return new ResponseEntity<>(jobService.searchByLocation(location), HttpStatus.FOUND);
    }
    @GetMapping("/search/maxSalary")
    public ResponseEntity<List<JobDetailsDTO>> searchJobsByMaxSalary(@RequestParam(name = "maxSalary", required = false) Double maxSalary) {
        return new ResponseEntity<>(jobService.searchByMaxSalary(maxSalary), HttpStatus.FOUND);
    }
    @GetMapping("/search/minSalary")
    public ResponseEntity<List<JobDetailsDTO>> searchJobsByMinSalary(@RequestParam(name = "minSalary", required = false) Double minSalary) {
        return new ResponseEntity<>(jobService.searchByMinSalary(minSalary), HttpStatus.FOUND);
    }
}