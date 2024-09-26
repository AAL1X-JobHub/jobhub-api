package com.al1x.jobhub.service;

import com.al1x.jobhub.domain.Application;
import com.al1x.jobhub.dto.ApplicationDto;

public interface ApplicationService {
    Application postulacionEmpleo(ApplicationDto applicationDto);
}
