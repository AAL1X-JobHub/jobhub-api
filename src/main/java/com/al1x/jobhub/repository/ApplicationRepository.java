package com.al1x.jobhub.repository;

import com.al1x.jobhub.domain.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query("SELECT a FROM Application a JOIN FETCH a.job j JOIN FETCH a.applicant app WHERE app.id = :id")
    List<Application> findByApplicantId(Integer id);

}