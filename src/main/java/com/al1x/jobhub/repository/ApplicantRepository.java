package com.al1x.jobhub.repository;

import com.al1x.jobhub.model.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}