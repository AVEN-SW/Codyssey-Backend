package com.cement.CodysseyBackend.domain.member.controller;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import com.cement.CodysseyBackend.domain.member.dto.MemberCreateRequest;
import com.cement.CodysseyBackend.domain.member.service.MemberService;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<Member> memberCreate(@RequestBody MemberCreateRequest request) {
        Member member = memberService.create(request);
        return ResponseEntity.ok()
                .body(member);
    }

    // TODO 로그인 기능
//    @GetMapping("/members")
//    public ResponseEntity<Member> memberLogin() {
//        boolean memberCheck = memberService.login();
//    }

}
