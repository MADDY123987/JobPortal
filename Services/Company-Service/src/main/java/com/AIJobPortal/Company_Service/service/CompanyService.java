package com.AIJobPortal.Company_Service.service;

import com.AIJobPortal.job.dto.request.CompanyRequest;
import com.AIJobPortal.job.dto.response.CompanyResponse;

public interface CompanyService {

    CompanyResponse createCompany(Long ownerId, CompanyRequest request);


}
