package com.cement.CodysseyBackend.domain.oauth.github.controller;

import com.cement.CodysseyBackend.domain.oauth.github.service.GithubService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class GithubController {

    private GithubService githubService;

    @GetMapping("/auth/github/callback")
    public String getCode(@RequestParam String code, RedirectAttributes redirectAttributes) throws IOException {
        String responseData = githubService.getCode(code);

        String githubData = githubService.access(responseData, redirectAttributes);
        return githubData;
    }
}