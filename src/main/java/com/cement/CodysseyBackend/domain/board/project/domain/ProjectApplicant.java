package com.cement.CodysseyBackend.domain.board.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "project_applicant")
@Getter
@NoArgsConstructor
public class ProjectApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id", updatable = false)
    private Long applicantId;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "applicant_user_id", nullable = false)
    private Long applicantUserId;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "content", nullable = false)
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
