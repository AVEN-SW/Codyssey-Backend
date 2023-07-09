package com.cement.CodysseyBackend.domain.board.favorites.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Scanner;

@Table(name = "project_favorites")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class ProjectFavorites {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_favorites_id")
    private Long projectFavoritesId;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "project_id")
    private Long projectId;

    @Builder
    public ProjectFavorites(Long memberId, Long projectId){
        this.memberId = memberId;
        this.projectId = projectId;
    }

}
