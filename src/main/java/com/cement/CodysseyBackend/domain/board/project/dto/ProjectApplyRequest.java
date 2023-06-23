package com.cement.CodysseyBackend.domain.board.project.dto;

import lombok.Getter;

@Getter
public class ProjectApplyRequest {

    private Long projectId;
    private Long applicantUserId;
    private String position;
    private String content;

}
