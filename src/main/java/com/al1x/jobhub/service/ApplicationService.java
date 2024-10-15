package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicationDetailsDto;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    // CRUD
    void createApplication(ApplicationDto applicationDto);
    void updateApplication(Integer id, ApplicationDto applicationDto);
    void deleteApplication(Integer id);
}
