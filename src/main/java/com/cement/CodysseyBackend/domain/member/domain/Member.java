package com.cement.CodysseyBackend.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "access_key")
    private String accessKey;

    @Column(name = "github_id", nullable = false, unique = true)
    private String githubId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp updateAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Member(String githubId, String username, String gender) {
        this.githubId = githubId;
        this.username = username;
        this.gender = gender;
        this.isDeleted = false;
    }
}
