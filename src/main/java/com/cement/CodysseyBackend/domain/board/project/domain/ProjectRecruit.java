package com.cement.CodysseyBackend.domain.board.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "project_recruit")
@Getter
@NoArgsConstructor
public class ProjectRecruit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_id", updatable = false)
    private Long recruitId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "recruited_user_id")
    private Long recruitedUserId;

    @Column(name = "position")
    private String position;

    @Builder
    public ProjectRecruit(Long projectId, Long recruitedUserId, String position) {
        this.projectId = projectId;
        this.recruitedUserId = recruitedUserId;
        this.position = position;
    }
}
