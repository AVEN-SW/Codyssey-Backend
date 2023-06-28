package com.cement.CodysseyBackend.domain.board.study.dto;

import lombok.Getter;

@Getter
public class StudyApplyRequest {
    private Long applicantUserId;
    private String content;
}