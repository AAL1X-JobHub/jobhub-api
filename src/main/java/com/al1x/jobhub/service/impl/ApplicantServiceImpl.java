package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.User;
import com.al1x.jobhub.dto.ApplicantDetailsDto;
import com.al1x.jobhub.dto.ApplicantDto;
import com.al1x.jobhub.dto.CurriculumUpdateDto;
import com.al1x.jobhub.dto.ApplicantUpdateDto;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.ApplicantMapper;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.UserRepository;
import com.al1x.jobhub.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final UserRepository userRepository;
    private final ApplicantMapper applicantMapper;

    @Transactional
    @Override
    public ApplicantDetailsDto createProfile(ApplicantDto applicantDto) {
        Applicant applicant = applicantMapper.toApplicant(applicantDto);

        User user = userRepository.findById(applicantDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: "+ applicantDto.getUserId()));

        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setDegree(applicantDto.getDegree());
        applicant.setDescription(applicantDto.getDescription());
        applicant.setCountry(applicantDto.getCountry());
        applicant.setCollege(applicantDto.getCollege());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhone(applicantDto.getPhone());
        applicant.setCurriculumPath(applicantDto.getCurriculumPath());
        applicant.setExperience(applicantDto.getExperience());
        applicant.setEducation(applicantDto.getEducation());
        applicant.setUser(user);

        applicant = applicantRepository.save(applicant);

        return applicantMapper.toApplicantDetailsDto(applicant);
    }

    @Override
    public Applicant readProfile(Integer id){
        Applicant applicant = applicantRepository.findById(id).orElse(null);
        return applicant;
    }

    @Override
    public Applicant updateProfile(Integer applicantId, ApplicantUpdateDto profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        applicant.setFirstName(profileUpdateDto.getFirstName());
        applicant.setLastName(profileUpdateDto.getLastName());
        applicant.setDegree(profileUpdateDto.getDegree());
        applicant.setDescription(profileUpdateDto.getDescription());
        applicant.setCountry(profileUpdateDto.getCountry());
        applicant.setCollege(profileUpdateDto.getCollege());
        applicant.setEmail(profileUpdateDto.getEmail());
        applicant.setPhone(profileUpdateDto.getPhone());
        applicant.setExperience(profileUpdateDto.getExperience());
        applicant.setEducation(profileUpdateDto.getEducation());

        applicant = applicantRepository.save(applicant);

        return applicant;
    }

    @Override
    public Applicant addCurriculum(Integer applicantId, CurriculumUpdateDto curriculumUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        applicant.setCurriculumPath(curriculumUpdateDto.getFilePath());
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant addInformationToProfile(Integer applicantId, ApplicantUpdateDto profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        applicant.setExperience(profileUpdateDto.getExperience());
        applicant.setEducation(profileUpdateDto.getEducation());
        return applicantRepository.save(applicant);
    }
}