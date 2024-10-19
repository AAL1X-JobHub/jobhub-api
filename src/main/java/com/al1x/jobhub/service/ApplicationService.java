package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.ApplicationDTO;
import com.al1x.jobhub.dto.ApplicationDetailsDTO;

public interface ApplicationService {
    // CRUD
    ApplicationDetailsDTO createApplication(ApplicationDTO applicationDto);
    void updateApplication(Integer id, ApplicationDTO applicationDto);
    void deleteApplication(Integer id);
    ApplicationDetailsDTO applicationJob(Integer id, Integer jobId);
}
