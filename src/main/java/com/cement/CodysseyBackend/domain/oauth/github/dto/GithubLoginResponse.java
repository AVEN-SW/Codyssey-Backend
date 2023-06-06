package com.cement.CodysseyBackend.domain.oauth.github.dto;

import java.util.List;

public class GithubLoginResponse {
    private boolean isCreated;
    private String github_id;
    private String avatar_url;
    private String username;
    private String gender;
    private List<String> stack;
    private String github_url;
}
