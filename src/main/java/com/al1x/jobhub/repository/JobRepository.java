package com.al1x.jobhub.repository;

import com.al1x.jobhub.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT j FROM Job j WHERE j.title = :title AND j.location = :location")
    List<Job> findJobsByCriteria(@Param("title") String title, @Param("location") String location);
    //List<Job> findJobsByCriteria(String degree, String country);

    @Query("SELECT j FROM Job j WHERE j.location = :location AND j.title = :title AND j.salaryRange >= :minSalary AND j.salaryRange <= :maxSalary")
    List<Job> findJobsByFilters(@Param("location") String location, @Param("title") String title, @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);
    //List<Job> findJobsByFilters(String jobType, String location, Double minSalary, Double maxSalary);
}