package com.al1x.jobhub.serviceImpl;

import com.al1x.jobhub.domain.Applicant;
import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.dto.ProfileUpdateDto;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Applicant crearPerfil(ApplicantDto applicantDto) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setDegree(applicantDto.getDegree());
        applicant.setDescription(applicantDto.getDescription());
        applicant.setCountry(applicantDto.getCountry());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhone(applicantDto.getPhone());

        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant adherirCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado"));

        applicant.setCurriculumPath(curriculumUpdateDto.getFilePath());
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant agregarInformacionAlPerfil(Integer applicantId, ProfileUpdateDto profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado"));
        applicant.setExperience(profileUpdateDto.getExperience());
        applicant.setEducation(profileUpdateDto.getEducation());
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant modificarPerfil(Integer applicantId, ProfileUpdateDto profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado"));

        applicant.setFirstName(profileUpdateDto.getFirstName());
        applicant.setLastName(profileUpdateDto.getLastName());
        applicant.setDegree(profileUpdateDto.getDegree());
        applicant.setDescription(profileUpdateDto.getDescription());
        applicant.setCountry(profileUpdateDto.getCountry());
        applicant.setCollege(profileUpdateDto.getCollege());
        applicant.setEmail(profileUpdateDto.getEmail());
        applicant.setPhone(profileUpdateDto.getPhone());

        return  applicantRepository.save(applicant);
    }
}
