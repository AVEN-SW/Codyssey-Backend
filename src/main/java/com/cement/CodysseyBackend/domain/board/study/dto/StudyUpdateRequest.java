package com.cement.CodysseyBackend.domain.board.study.dto;

import lombok.Getter;

@Getter
public class StudyUpdateRequest {
    private String title;
    private String content;
    private String category;
}