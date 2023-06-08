package com.cement.CodysseyBackend.domain.oauth.github.controller;

import com.cement.CodysseyBackend.domain.oauth.github.domain.Access;
import com.cement.CodysseyBackend.domain.oauth.github.dto.AccessTokenResponse;
import com.cement.CodysseyBackend.domain.oauth.github.dto.GithubLoginResponse;
import com.cement.CodysseyBackend.domain.oauth.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@RestController
public class GithubController {

    private final GithubService githubService;

    @GetMapping("/auth/github/callback")
    public ResponseEntity<AccessTokenResponse> getCode(@RequestParam String code, RedirectAttributes redirectAttributes){
        String responseData = githubService.getCode(code);
        String access_token = githubService.getAccessToken(responseData);
        GithubLoginResponse githubData = githubService.access(access_token);

        Access response = Access.builder()
                .githubId(githubData.getGithub_id())
                .accessToken(access_token)
                .build();
        githubService.saveAccessToken(response);

        boolean isCreated = githubData.isCreated();

        AccessTokenResponse accessTokenResponse = AccessTokenResponse.builder()
                .github_id(githubData.getGithub_id())
                .access_token(access_token)
                .isCreated(githubData.isCreated())
                .build();

        if (isCreated) {
            // Member가 있을 경우 Member Table에 Access Token 등록
            githubService.saveMemberAccessToken(response);
        }
        return ResponseEntity.ok()
                .body(accessTokenResponse);
    }
}