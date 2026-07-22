package com.AIJobPortal.Company_Service.Model;

import com.AIJobPortal.job.domain.SocialPlatform;
import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLink {

    private SocialPlatform platform;
    private String url;


}
