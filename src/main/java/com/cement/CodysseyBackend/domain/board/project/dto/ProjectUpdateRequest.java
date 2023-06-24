package com.cement.CodysseyBackend.domain.board.project.dto;

import lombok.Getter;

@Getter
public class ProjectUpdateRequest {

//    private Long writerId;
    private String title;
    private String content;
    private int frontNum;
    private int backNum;
    private int designNum;
}
