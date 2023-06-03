package com.cement.CodysseyBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class CodysseyBackendApplication{

//	@GetMapping("/user")
//	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//		Map<String, Object> c = Collections.singletonMap("name", principal.getAttributes());
//		return c;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CodysseyBackendApplication.class, args);
	}
}
