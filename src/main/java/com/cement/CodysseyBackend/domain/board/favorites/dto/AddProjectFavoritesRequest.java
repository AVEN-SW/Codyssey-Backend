package com.cement.CodysseyBackend.domain.board.favorites.dto;

import lombok.Getter;

@Getter
public class AddProjectFavoritesRequest {
    private Long projectId;
    private Long memberId;
}
