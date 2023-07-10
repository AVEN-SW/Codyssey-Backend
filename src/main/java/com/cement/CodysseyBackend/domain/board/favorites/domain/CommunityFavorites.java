package com.cement.CodysseyBackend.domain.board.favorites.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "community_favorites")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class CommunityFavorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_favorites_id")
    private Long communityFavoritesId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "community_id")
    private Long communityId;

    @Builder
    public CommunityFavorites(Long memberId, Long communityId) {
        this.memberId = memberId;
        this.communityId = communityId;
    }
}
