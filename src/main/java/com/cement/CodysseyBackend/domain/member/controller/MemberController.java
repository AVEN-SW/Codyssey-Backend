package com.cement.CodysseyBackend.domain.member.controller;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import com.cement.CodysseyBackend.domain.member.dto.MemberCreateRequest;
import com.cement.CodysseyBackend.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
