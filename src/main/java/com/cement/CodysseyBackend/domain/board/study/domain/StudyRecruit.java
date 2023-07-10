package com.cement.CodysseyBackend.domain.board.study.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "study_recruit")
@Getter
public class StudyRecruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_id")
    private Long recruitId;

    @Column(name = "study_id")
    private Long studyId;

    @Column(name = "recruit_user_id")
    private Long recruitUserId;

    @Builder
    public StudyRecruit(Long studyId, Long recruitUserId) {
        this.studyId = studyId;
        this.recruitUserId = recruitUserId;
    }
}
