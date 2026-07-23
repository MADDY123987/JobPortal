package com.AIJobPortal.job.dto.request;

import com.AIJobPortal.job.domain.CompanySize;
import com.AIJobPortal.job.domain.CompanyStatus;
import com.AIJobPortal.job.domain.CompanyType;
import com.AIJobPortal.job.domain.IndustryType;
import com.AIJobPortal.job.dto.response.SocialLinkResponse;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRequest {
    @NotBlank(message = "Company name is required")
    private String name;

    private String tagline;
    private String description;
    private String logoUrl;
    private String coverImageUrl;

    @Pattern(regexp = "^(https?://).*",message = "Website must be a valid URL")
    private String website;

    @Email(message = "Company email must be valid")
    private String email;

    private String phone;

    @Min(value = 1800,message = "Founded Year seems too old")
    @Max(value = 2100,message = "Founded Year is Invalid")
    private Integer foundedYear;

    @NotNull(message = "Company Size is Required")
    private CompanySize companySize;

    @NotNull(message = "Company Type is Required")
    private CompanyType companyType;

    @NotNull(message = "Industry Type is Required")
    private IndustryType industryType;

    private String registrationNumber;


    private List<SocialLinkResponse> socialLinks;

}
