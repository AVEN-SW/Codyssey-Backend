package com.cement.CodysseyBackend.domain.oauth.github.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GithubUrlController {

    @GetMapping("/oauth/github")
    public String redirectUrl() {
        return "redirect:https://github.com/login/oauth/authorize?client_id=ae435d706af35e3a7041&redirect_uri=http://cement.kro.kr:8080/auth/github/callback";
    }
}
