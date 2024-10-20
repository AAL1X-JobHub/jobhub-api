package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.mapper.ApplicationMapper;
import com.al1x.jobhub.mapper.JobMapper;
import com.al1x.jobhub.domain.entity.Applicant;
import com.al1x.jobhub.domain.entity.User;
import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.mapper.ApplicantMapper;
import com.al1x.jobhub.repository.ApplicantRepository;
import com.al1x.jobhub.repository.ApplicationRepository;
import com.al1x.jobhub.repository.JobRepository;
import com.al1x.jobhub.repository.UserRepository;
import com.al1x.jobhub.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final UserRepository userRepository;
    private final ApplicantMapper applicantMapper;
    private final JobRepository jobRepository;
    private final ApplicationMapper applicationMapper;
    private final ApplicationRepository applicationRepository;
    private final JobMapper jobMapper;

    // Another Functions
    @Override
    public List<ApplicantDetailsDTO> readApplicants() { return applicantRepository.findAll().stream().map(applicantMapper::toApplicantDetailsDTO).collect(Collectors.toList()); }
    @Override
    @Transactional
    public List<ApplicationDetailsDTO> readApplicationHistory(Integer id) {
        return applicationRepository.findByApplicantId(id).stream().map(applicationMapper::toApplicationDetailsDto).collect(Collectors.toList());
    }

    // CRUD
    @Transactional
    @Override
    public ApplicantDetailsDTO createApplicant(ApplicantDTO applicantDto) {
        Applicant applicant = applicantMapper.toApplicant(applicantDto);

        User user = userRepository.findByEmail(applicantDto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("El usuario con correo " + applicantDto.getEmail() + " no fue encontrado"));

        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setDegree(applicantDto.getDegree());
        applicant.setDescription(applicantDto.getDescription());
        applicant.setCountry(applicantDto.getCountry());
        applicant.setCollege(applicantDto.getCollege());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhone(applicantDto.getPhone());
        applicant.setCurriculumPath(" ");
        applicant.setExperience(" ");
        applicant.setEducation(" ");
        applicant.setUser(user);

        applicantRepository.save(applicant);

        return applicantMapper.toApplicantDetailsDTO(applicant);
    }
    @Override
    public ApplicantDetailsDTO readApplicant(Integer id){
        return applicantMapper.toApplicantDetailsDTO(applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado")));
    }
    @Transactional
    @Override
    public ApplicantDetailsDTO updateApplicant(Integer id, ApplicantUpdateDTO applicantUpdateDTO) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        applicant.setFirstName(applicantUpdateDTO.getFirstName());
        applicant.setLastName(applicantUpdateDTO.getLastName());
        applicant.setDegree(applicantUpdateDTO.getDegree());
        applicant.setDescription(applicantUpdateDTO.getDescription());
        applicant.setCountry(applicantUpdateDTO.getCountry());
        applicant.setCollege(applicantUpdateDTO.getCollege());
        applicant.setPhone(applicantUpdateDTO.getPhone());

        applicantRepository.save(applicant);

        return applicantMapper.toApplicantDetailsDTO(applicant);
    }
    @Transactional
    @Override
    public void deleteApplicant(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));
        applicantRepository.delete(applicant);
    }

    // US 14
    @Transactional
    @Override
    public ApplicantDetailsDTO addApplicantCurriculum(Integer id, ApplicantCurriculumUpdateDTO curriculumUpdateDto) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        applicant.setCurriculumPath(curriculumUpdateDto.getCurriculumPath());

        applicantRepository.save(applicant);

        return applicantMapper.toApplicantDetailsDTO(applicant);
    }
    // US 15
    @Transactional
    @Override
    public ApplicantDetailsDTO addApplicantInformation(Integer id, ApplicantInformationUpdateDTO applicantInformationUpdateDTO) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        applicant.setExperience(applicantInformationUpdateDTO.getExperience());
        applicant.setEducation(applicantInformationUpdateDTO.getEducation());

        applicantRepository.save(applicant);

        return applicantMapper.toApplicantDetailsDTO(applicant);
    }
    // US 19
    @Override
    public JobRecommendedDTO recommendedJobs(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<JobDetailsDTO> recommendedJobs = jobRepository.recommendedJobs(applicant.getDegree(), applicant.getCountry()).stream().map(jobMapper::toJobDetailsDto).collect(Collectors.toList());
        JobRecommendedDTO applicantJobRecommendedDto = new JobRecommendedDTO();

        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }
    @Override
    public JobRecommendedDTO recommendedByTitle(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<JobDetailsDTO> recommendedJobs = jobRepository.recommendedByTitle(applicant.getDegree()).stream().map(jobMapper::toJobDetailsDto).collect(Collectors.toList());
        JobRecommendedDTO applicantJobRecommendedDto = new JobRecommendedDTO();

        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }
    @Override
    public JobRecommendedDTO recommendedByLocation(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<JobDetailsDTO> recommendedJobs = jobRepository.recommendedByLocation(applicant.getCountry()).stream().map(jobMapper::toJobDetailsDto).collect(Collectors.toList());
        JobRecommendedDTO applicantJobRecommendedDto = new JobRecommendedDTO();

        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }

}