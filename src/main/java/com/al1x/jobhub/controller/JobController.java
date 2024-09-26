package com.al1x.jobhub.controller;

import com.al1x.jobhub.domain.Job;
import com.al1x.jobhub.dto.SearchFilterDto;
import com.al1x.jobhub.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam(name = "jobType", required = false) String jobType,
                                @RequestParam(name = "location", required = false) String location,
                                @RequestParam(name = "maxSalary", required = false) Double maxSalary,
                                @RequestParam(name = "minSalary", required = false) Double minSalary) {
        return jobService.filterJobs(jobType, location, minSalary, minSalary);
    }
}
