package com.al1x.jobhub.api;

import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.dto.JobDetailsDto;
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

    @GetMapping()
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.listJobs();
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id){
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/filters")
    public List<Job> searchJobsByFilters(@RequestParam(name = "jobType", required = false) String jobType,
                                         @RequestParam(name = "location", required = false) String location,
                                         @RequestParam(name = "maxSalary", required = false) Double maxSalary,
                                         @RequestParam(name = "minSalary", required = false) Double minSalary) {
        return jobService.filterJobs(jobType, location, maxSalary, minSalary);
    }

    @GetMapping("/search/type")
    public List<Job> searchJobsByType(@RequestParam(name = "jobType", required = false) String jobType) {
        return jobService.filterByJobType(jobType);
    }
    @GetMapping("/search/location")
    public List<Job> searchJobsByLocation(@RequestParam(name = "location", required = false) String location) {
        return jobService.filterByLocation(location);
    }
    @GetMapping("/search/max-salary")
    public List<Job> searchJobsByMaxSalary(@RequestParam(name = "maxSalary", required = false) Double maxSalary) {
        return jobService.filterByMaxSalary(maxSalary);
    }
    @GetMapping("/search/min-salary")
    public List<Job> searchJobsByMinSalary(@RequestParam(name = "minSalary", required = false) Double minSalary) {
        return jobService.filterByMinSalary(minSalary);
    }

    @PostMapping("/create")
    public ResponseEntity<JobDetailsDto> createJob(@RequestBody JobDto jobDto) {
        JobDetailsDto jobDetailsDto = jobService.createJob(jobDto);
        return new ResponseEntity<>(jobDetailsDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable("id") Integer id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<String> modifyJob(@PathVariable("id") Integer id, @RequestBody JobUpdateDto jobUpdateDto) {
        jobService.updateJob(id, jobUpdateDto);
        return ResponseEntity.ok("Trabajo modificado correctamente");
    }
}
