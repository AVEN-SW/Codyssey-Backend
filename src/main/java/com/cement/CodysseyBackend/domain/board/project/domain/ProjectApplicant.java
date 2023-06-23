package com.cement.CodysseyBackend.domain.board.project.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "project_applicant")
@Getter
public class ProjectApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id", updatable = false)
    private Long applicantId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "applicant_user_id")
    private Long applicantUserId;

    @Column(name = "position")
    private String position;

    @Column(name = "content")
    private String content;

    @Builder
    public ProjectApplicant(
                            Long projectId,
                            Long applicantUserId,
                            String position,
                            String content) {
        this.projectId = projectId;
        this.applicantUserId = applicantUserId;
        this.position = position;
        this.content = content;
    }

}
