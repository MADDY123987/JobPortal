package com.AIJobPortal.Company_Service.service.Impl;

import com.AIJobPortal.Company_Service.Model.Company;
import com.AIJobPortal.Company_Service.service.CompanyService;
import com.AIJobPortal.job.domain.CompanyStatus;
import com.AIJobPortal.job.domain.CompanyType;
import com.AIJobPortal.job.domain.IndustryType;
import com.AIJobPortal.job.dto.request.CompanyRequest;
import com.AIJobPortal.job.dto.response.CompanyResponse;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public CompanyResponse createCompany(Long ownerId, CompanyRequest request) {
        return null;
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        return null;
    }

    @Override
    public CompanyResponse getMyCompany(Long ownerId) {
        return null;
    }

    @Override
    public List<CompanyResponse> getAllCompanies(CompanyType companyType, IndustryType industryType, CompanyStatus companyStatus) {
        return List.of();
    }

    @Override
    public CompanyResponse updateCompany(Long companyId, Long ownerId, CompanyRequest request) {
        return null;
    }

    @Override
    public CompanyResponse verifyCompany(Long companyId) {
        return null;
    }

    @Override
    public void deleteCompany(Long companyId) {

    }

    @Override
    public CompanyResponse deactivateCompany(Long companyId) {
        return null;
    }

    @Override
    public Company getCompanyEntityById(Long id) {
        return null;
    }
}
