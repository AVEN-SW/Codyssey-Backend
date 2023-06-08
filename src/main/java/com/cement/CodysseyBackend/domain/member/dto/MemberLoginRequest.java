package com.cement.CodysseyBackend.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginRequest {
    private String access_token;
}
