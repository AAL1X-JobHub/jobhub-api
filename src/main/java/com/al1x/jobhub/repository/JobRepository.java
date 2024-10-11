package com.al1x.jobhub.repository;

import com.al1x.jobhub.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query("SELECT j FROM Job j WHERE j.title = :title AND j.location = :location")
    List<Job> findJobsByCriteria(@Param("title") String title, @Param("location") String location);

    @Query("SELECT j FROM Job j WHERE j.jobType = :jobType AND j.location = :location AND j.salaryRange >= :minSalary AND j.salaryRange <= :maxSalary")
    List<Job> findJobsByFilters(@Param("jobType") String jobType,
                                @Param("location") String location,
                                @Param("minSalary") Double minSalary,
                                @Param("maxSalary") Double maxSalary);

    @Query("SELECT j FROM Job j WHERE j.jobType = :jobType")
    List<Job> findJobsByJobType(@Param("jobType") String jobType);

    @Query("SELECT j FROM Job j WHERE j.location = :location")
    List<Job> findJobsByLocation(@Param("location") String location);

    @Query("SELECT j FROM Job j WHERE j.salaryRange >= :maxSalary")
    List<Job> findJobsByMaxSalary(@Param("maxSalary") Double maxSalary);

    @Query("SELECT j FROM Job j WHERE j.salaryRange <= :minSalary")
    List<Job> findJobsByMinSalary(@Param("minSalary") Double minSalary);
}