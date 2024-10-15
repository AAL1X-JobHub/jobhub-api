package com.al1x.jobhub.api;

import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.dto.JobDto;
import com.al1x.jobhub.dto.JobUpdateDto;
import com.al1x.jobhub.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    // Another Functions
    @GetMapping("/read")
    public ResponseEntity<List<Job>> getAllJobs(){
        return new ResponseEntity<>(jobService.readJobs(), HttpStatus.FOUND);
    }

    // CRUD
    @PostMapping("/create")
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto) {
        jobService.createJob(jobDto);
        return new ResponseEntity<>("El trabajo fue creado correctamente", HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Job> readJob(@PathVariable("id") Integer id){
        return new ResponseEntity<>(jobService.readJob(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> modifyJob(@PathVariable("id") Integer id, @RequestBody JobUpdateDto jobUpdateDto) {
        jobService.updateJob(id, jobUpdateDto);
        return new ResponseEntity<>("El trabajo fue modificado correctamente", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Integer id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>("El trabajo fue eliminado correctamente", HttpStatus.OK);
    }

    // US 20
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobsByFilters(@RequestParam(name = "jobType", required = false) String jobType,
                                         @RequestParam(name = "location", required = false) String location,
                                         @RequestParam(name = "maxSalary", required = false) Double maxSalary,
                                         @RequestParam(name = "minSalary", required = false) Double minSalary) {
        return new ResponseEntity<>(jobService.searchJobs(jobType, location, maxSalary, minSalary), HttpStatus.FOUND);
    }
    @GetMapping("/search/type")
    public ResponseEntity<List<Job>> searchJobsByType(@RequestParam(name = "jobType", required = false) String jobType) {
        return new ResponseEntity<>(jobService.searchByJobType(jobType), HttpStatus.FOUND);
    }
    @GetMapping("/search/location")
    public ResponseEntity<List<Job>> searchJobsByLocation(@RequestParam(name = "location", required = false) String location) {
        return new ResponseEntity<>(jobService.searchByLocation(location), HttpStatus.FOUND);
    }
    @GetMapping("/search/maxSalary")
    public ResponseEntity<List<Job>> searchJobsByMaxSalary(@RequestParam(name = "maxSalary", required = false) Double maxSalary) {
        return new ResponseEntity<>(jobService.searchByMaxSalary(maxSalary), HttpStatus.FOUND);
    }
    @GetMapping("/search/minSalary")
    public ResponseEntity<List<Job>> searchJobsByMinSalary(@RequestParam(name = "minSalary", required = false) Double minSalary) {
        return new ResponseEntity<>(jobService.searchByMinSalary(minSalary), HttpStatus.FOUND);
    }
}