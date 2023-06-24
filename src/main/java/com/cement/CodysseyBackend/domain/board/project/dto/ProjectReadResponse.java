package com.cement.CodysseyBackend.domain.board.project.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ProjectReadResponse {

    private Long projectId;
    private Long writerId;
    private String title;
    private String content;
    private Long saveCount;
    private int frontNum;
    private int backNum;
    private int designNum;
    private boolean isClosed;
    private Timestamp createAt;
    private Timestamp updateAt;
    private boolean isDeleted;

}
