package com.cement.CodysseyBackend.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "profile")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", updatable = false)
    private Long memberId;

    @Column(name = "avatar_url", nullable = false, unique = true)
    private String avatarUrl;

    @Column(name = "github_url", nullable = false, unique = true)
    private String githubUrl;

    @Builder
    public Profile(Long memberId, String avatarUrl, String githubUrl) {
        this.memberId = memberId;
        this.avatarUrl = avatarUrl;
        this.githubUrl = githubUrl;
    }
}
