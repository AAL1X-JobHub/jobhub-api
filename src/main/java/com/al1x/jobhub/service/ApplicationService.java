package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicationDetailsDto;
import com.al1x.jobhub.model.entity.Application;
import com.al1x.jobhub.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDetailsDto EmploymentApplication(ApplicationDto applicationDto);
    List<Application> getApplicationHistory(Integer userId);
}
