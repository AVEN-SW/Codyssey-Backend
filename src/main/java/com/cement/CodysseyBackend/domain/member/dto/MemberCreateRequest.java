package com.cement.CodysseyBackend.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
public class MemberCreateRequest {
    private String github_id;
    private String avatar_url;
    private String username;
    private String gender;
    private List<String> stack;
    private String github_url;
}
