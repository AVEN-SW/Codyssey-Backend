package com.cement.CodysseyBackend.domain.oauth.github.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class GithubLoginResponse {
    @Setter
    private boolean isCreated;
    private String github_id;
    private String avatar_url;
    private String username;
    private String github_url;
}


