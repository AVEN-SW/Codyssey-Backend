package com.cement.CodysseyBackend.domain.board.study.dto;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import lombok.Getter;

@Getter
public class StudyCreateRequest {
    private Long writerId;
    private String title;
    private String content;
    private String category;

    public static Study toEntity(StudyCreateRequest dto) {
        return Study.builder()
                .writerId(dto.getWriterId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .category(dto.getCategory())
                .build();
    }
}
