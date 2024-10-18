package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.dto.*;
import com.al1x.jobhub.mapper.ApplicationMapper;
import com.al1x.jobhub.model.entity.Applicant;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.model.entity.Job;
import com.al1x.jobhub.model.entity.User;
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

import java.time.LocalDate;
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

    // Another Functions
    @Override
    public List<Applicant> readApplicants() { return applicantRepository.findAll(); }
    @Override
    @Transactional
    public List<Application> readApplicationHistory(Integer id) {
        return applicationRepository.findByApplicantId(id);
    }

    // CRUD
    @Transactional
    @Override
    public void createApplicant(ApplicantDTO applicantDto) {
        Applicant applicant = applicantMapper.toApplicant(applicantDto);

        User user = userRepository.findById(applicantDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID " + applicantDto.getUserId() + " no fue encontrado"));

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

        applicantRepository.save(applicant);
    }
    @Override
    public Applicant readApplicant(Integer id){
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));
        return applicant;
    }
    @Transactional
    @Override
    public void updateApplicant(Integer id, ApplicantUpdateDTO profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

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

        applicantRepository.save(applicant);
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
    public void addApplicantCurriculum(Integer id, CurriculumUpdateDTO curriculumUpdateDto) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        applicant.setCurriculumPath(curriculumUpdateDto.getFilePath());

        applicantRepository.save(applicant);
    }
    // US 15
    @Transactional
    @Override
    public void addApplicantInformation(Integer id, ApplicantUpdateDTO profileUpdateDto) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        applicant.setExperience(profileUpdateDto.getExperience());
        applicant.setEducation(profileUpdateDto.getEducation());

        applicantRepository.save(applicant);
    }
    // US 19
    @Override
    public ApplicantJobRecommendedDTO recommendedJobs(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<Job> recommendedJobs = jobRepository.recommendedJobs(applicant.getDegree(), applicant.getCountry());
        List<Integer> recommendedJobIds = recommendedJobs.stream().map(Job::getId).collect(Collectors.toList());
        ApplicantJobRecommendedDTO applicantJobRecommendedDto = new ApplicantJobRecommendedDTO();

        applicantJobRecommendedDto.setApplicantId(id);
        applicantJobRecommendedDto.setRecommendedJobIds(recommendedJobIds);
        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }
    @Override
    public ApplicantJobRecommendedDTO recommendedByTitle(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<Job> recommendedJobs = jobRepository.recommendedByTitle(applicant.getDegree());
        List<Integer> recommendedJobIds = recommendedJobs.stream().map(Job::getId).collect(Collectors.toList());
        ApplicantJobRecommendedDTO applicantJobRecommendedDto = new ApplicantJobRecommendedDTO();

        applicantJobRecommendedDto.setApplicantId(id);
        applicantJobRecommendedDto.setRecommendedJobIds(recommendedJobIds);
        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }
    @Override
    public ApplicantJobRecommendedDTO recommendedByLocation(Integer id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        List<Job> recommendedJobs = jobRepository.recommendedByLocation(applicant.getCountry());
        List<Integer> recommendedJobIds = recommendedJobs.stream().map(Job::getId).collect(Collectors.toList());
        ApplicantJobRecommendedDTO applicantJobRecommendedDto = new ApplicantJobRecommendedDTO();

        applicantJobRecommendedDto.setApplicantId(id);
        applicantJobRecommendedDto.setRecommendedJobIds(recommendedJobIds);
        applicantJobRecommendedDto.setRecommendedJobs(recommendedJobs);

        return applicantJobRecommendedDto;
    }
    // US 18
    @Transactional
    @Override
    public void applicationJob(Integer id, Integer jobId) {
        Application application = new Application();

        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("El trabajo con ID " + jobId + " no fue encontrado"));
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El perfil con ID " + id + " no fue encontrado"));

        application.setDateCreated(LocalDate.now());
        application.setJob(job);
        application.setApplicant(applicant);

        applicationRepository.save(application);
    }
}