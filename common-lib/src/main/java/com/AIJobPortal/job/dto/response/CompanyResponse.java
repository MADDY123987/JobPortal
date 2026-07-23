package com.AIJobPortal.job.dto.response;

import com.AIJobPortal.job.domain.CompanySize;
import com.AIJobPortal.job.domain.CompanyStatus;
import com.AIJobPortal.job.domain.CompanyType;
import com.AIJobPortal.job.domain.IndustryType;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse {
    private Long id;
    private String name;
    private String slug;
    private String tagline;
    private String description;
    private String logoUrl;
    private String coverImageUrl;
    private String website;
    private String phone;
    private String email;
    private Integer foundedYear;

    private CompanySize companySize;
    private CompanyType companyType;
    private IndustryType industryType;
    private CompanyStatus status;
    private Boolean active;

    private Long ownerId;

    private List<SocialLinkResponse> socialLinks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime verifiedAt;

}
