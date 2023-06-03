package com.cement.CodysseyBackend.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class MemberDto {
    private String username;
    private String name;
    private String avatarUrl;
    private int followersCount;
    private String location;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
