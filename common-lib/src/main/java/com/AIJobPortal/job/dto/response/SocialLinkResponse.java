package com.AIJobPortal.job.dto.response;

import com.AIJobPortal.job.domain.SocialPlatform;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLinkResponse {
    private SocialPlatform platform;
    private String url;
}
