package com.cement.CodysseyBackend.domain.board.favorites.dto;

import lombok.Getter;

@Getter
public class AddStudyFavoritesRequest {
    private Long memberId;
    private Long studyId;
}
