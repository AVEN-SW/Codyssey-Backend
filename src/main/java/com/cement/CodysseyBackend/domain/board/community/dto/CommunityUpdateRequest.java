package com.cement.CodysseyBackend.domain.board.community.dto;

import lombok.Getter;

@Getter
public class CommunityUpdateRequest {
    private String title;
    private String content;
    private String category;
}
