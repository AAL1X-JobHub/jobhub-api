package com.al1x.jobhub.serviceImpl;

import com.al1x.jobhub.entity.Job;
import com.al1x.jobhub.repository.EmploymentRepository;
import com.al1x.jobhub.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentServiceImpl implements EmploymentService {
    @Autowired
    private EmploymentRepository employmentRepository;
    @Override
    public List<Job> listJobs() {
        return employmentRepository.findAll();
    }
}
