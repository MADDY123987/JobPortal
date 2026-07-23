package com.AIJobPortal.Company_Service.service;

import com.AIJobPortal.Company_Service.Model.Company;
import com.AIJobPortal.job.domain.CompanyStatus;
import com.AIJobPortal.job.domain.CompanyType;
import com.AIJobPortal.job.domain.IndustryType;
import com.AIJobPortal.job.dto.request.CompanyRequest;
import com.AIJobPortal.job.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    CompanyResponse createCompany(Long ownerId, CompanyRequest request);
    CompanyResponse getCompanyById(Long id);
    CompanyResponse getMyCompany(Long ownerId);
    List<CompanyResponse> getAllCompanies(CompanyType companyType,
                                          IndustryType industryType,
                                          CompanyStatus companyStatus);
    CompanyResponse updateCompany(Long companyId,Long ownerId,CompanyRequest request);
    CompanyResponse verifyCompany(Long companyId);
    void deleteCompany(Long companyId);
    CompanyResponse deactivateCompany(Long companyId);
    Company getCompanyEntityById(Long id);

}
