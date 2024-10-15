package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicationDto;

public interface ApplicationService {
    // CRUD
    void createApplication(ApplicationDto applicationDto);
    void updateApplication(Integer id, ApplicationDto applicationDto);
    void deleteApplication(Integer id);
}
