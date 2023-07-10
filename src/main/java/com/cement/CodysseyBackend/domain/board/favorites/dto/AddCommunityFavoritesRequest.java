package com.cement.CodysseyBackend.domain.board.favorites.dto;

import lombok.Getter;

@Getter
public class AddCommunityFavoritesRequest {
    private Long memberId;
    private Long communityId;
}
