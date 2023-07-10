package com.cement.CodysseyBackend.domain.oauth.github.controller;

import com.cement.CodysseyBackend.domain.oauth.github.domain.Access;
import com.cement.CodysseyBackend.domain.oauth.github.dto.AccessTokenResponse;
import com.cement.CodysseyBackend.domain.oauth.github.dto.GithubLoginResponse;
import com.cement.CodysseyBackend.domain.oauth.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@RestController
public class GithubController {

    private final GithubService githubService;

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AccessTokenResponse getCode(@RequestParam String code) {
        // code로 AccessToken 가져오기
        String responseData = githubService.getCode(code);
        // response에서 AccessToken만 가져오기
        String access_token = githubService.getAccessToken(responseData);
        // AccessToken으로 정보 가져오기
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
        return accessTokenResponse;
    }
}