package com.cement.CodysseyBackend.domain.board.community.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "community")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Community {

    @Id @GeneratedValue
    @Column(name = "community_id")
    private Long communityId;

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Setter
    @Column(name = "like_count", nullable = false)
    private Long likeCount;

    @Setter
    @Column(name = "dislike_count", nullable = false)
    private Long dislikeCount;

    @Column(name = "save_count", nullable = false)
    private Long saveCount;

    @Column(name = "createAt", nullable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @Column(name = "updateAt", nullable = false)
    @UpdateTimestamp
    private Timestamp updateAt;

    @Setter
    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "category", nullable = false)
    private String category;

    @Builder
    public Community(
            Long writerId, String title, String content, String category) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.likeCount = 0L;
        this.dislikeCount = 0L;
        this.saveCount = 0L;
        this.isDeleted = false;
        this.category = category;
    }
}
