package com.al1x.jobhub.repository;

import com.al1x.jobhub.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    // US 20
    @Query("SELECT j FROM Job j WHERE j.jobType = :jobType AND j.location = :location AND j.salaryRange >= :minSalary AND j.salaryRange <= :maxSalary")
    List<Job> searchJobs(@Param("jobType") String jobType, @Param("location") String location, @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);
    @Query("SELECT j FROM Job j WHERE j.jobType = :jobType")
    List<Job> searchByJobType(@Param("jobType") String jobType);
    @Query("SELECT j FROM Job j WHERE j.location = :location")
    List<Job> searchByLocation(@Param("location") String location);
    @Query("SELECT j FROM Job j WHERE j.salaryRange >= :maxSalary")
    List<Job> searchByMaxSalary(@Param("maxSalary") Double maxSalary);
    @Query("SELECT j FROM Job j WHERE j.salaryRange <= :minSalary")
    List<Job> searchByMinSalary(@Param("minSalary") Double minSalary);

    // US 19
    @Query("SELECT j FROM Job j WHERE j.title = :title AND j.location = :location")
    List<Job> recommendedJobs(@Param("title") String title, @Param("location") String location);
    @Query("SELECT j FROM Job j WHERE j.title = :title")
    List<Job> recommendedByTitle(@Param("title") String title);
    @Query("SELECT j FROM Job j WHERE j.location = :location")
    List<Job> recommendedByLocation(@Param("location") String location);
}