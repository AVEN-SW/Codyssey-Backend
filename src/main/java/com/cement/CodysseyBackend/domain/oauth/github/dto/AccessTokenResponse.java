package com.cement.CodysseyBackend.domain.oauth.github.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessTokenResponse {
    private boolean isCreated;
    private String github_id;
    private String access_token;
}
