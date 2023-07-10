package com.cement.CodysseyBackend.domain.board.study.dto;

import lombok.Getter;

@Getter
public class StudyCancelRequest {
    private Long studyId;
    private Long cancelUserId;
}
