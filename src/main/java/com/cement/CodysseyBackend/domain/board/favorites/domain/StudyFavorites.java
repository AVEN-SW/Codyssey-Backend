package com.cement.CodysseyBackend.domain.board.favorites.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "study_favorites")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class StudyFavorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_favorites_id")
    private Long studyFavoritesId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "study_id")
    private Long studyId;

    @Builder
    public StudyFavorites(Long memberId, Long studyId) {
        this.memberId = memberId;
        this.studyId = studyId;
    }
}
