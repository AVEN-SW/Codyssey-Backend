package com.cement.CodysseyBackend.domain.oauth.github.controller;

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
    public ResponseEntity<GithubLoginResponse> getCode(@RequestParam String code, RedirectAttributes redirectAttributes){
        String responseData = githubService.getCode(code);

        GithubLoginResponse githubData = githubService.access(responseData, redirectAttributes);
        githubData.setCreated(githubService.createCheck(githubData));

//        System.out.println(githubData.getGithub_id());
//        System.out.println(githubData.getGithub_url());
//        System.out.println(githubData.getAvatar_url());
//        System.out.println(githubData.getUsername());
//        System.out.println(githubData.isCreated());

        return ResponseEntity.ok()
                .body(githubData);
    }
}