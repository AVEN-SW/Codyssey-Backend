package com.cement.CodysseyBackend.domain.board.community.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "like_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class LikeMember {

    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "community_id", nullable = false)
    private Long communityId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "flag", nullable = false)
    private String flag;

    @Builder
    public LikeMember(Long communityId, Long memberId, String flag) {
        this.communityId = communityId;
        this.memberId = memberId;
        this.flag = flag;
    }
}
