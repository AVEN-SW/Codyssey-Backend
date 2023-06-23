package com.cement.CodysseyBackend.domain.board.study.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "study_applicant")
@Getter
public class StudyApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Long applicantId;

    @Column(name = "study_id")
    private Long studyId;

    @Column(name = "applicant_user_id")
    private Long applicantUserId;

    @Column(name = "content")
    private String content;

    @Builder
    public StudyApplicant(Long studyId, Long applicantUserId, String content) {
        this.studyId = studyId;
        this.applicantUserId = applicantUserId;
        this.content = content;
    }
}
