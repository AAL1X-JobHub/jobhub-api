package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicationDTO;

public interface ApplicationService {
    // CRUD
    void createApplication(ApplicationDTO applicationDto);
    void updateApplication(Integer id, ApplicationDTO applicationDto);
    void deleteApplication(Integer id);
}
