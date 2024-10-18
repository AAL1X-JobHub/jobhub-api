package com.al1x.jobhub.repository;

import com.al1x.jobhub.model.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    Optional<Applicant> findByFirstNameAndLastName(String firstName, String lastName);
    Applicant findByEmail(String email);
}