package com.cement.CodysseyBackend.domain.board.study.dto;

import lombok.Getter;

@Getter
public class StudyCreateRequest {
    private Long writerId;
    private String title;
    private String content;
    private String category;
}
