package com.al1x.jobhub.repository;

import com.al1x.jobhub.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepository extends JpaRepository<Job, Integer> {

}
