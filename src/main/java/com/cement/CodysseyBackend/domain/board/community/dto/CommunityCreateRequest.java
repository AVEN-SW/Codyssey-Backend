package com.cement.CodysseyBackend.domain.board.community.dto;

import lombok.Getter;

@Getter
public class CommunityCreateRequest {
        private Long writerId;
        private String title;
        private String content;
        private String category;
}
