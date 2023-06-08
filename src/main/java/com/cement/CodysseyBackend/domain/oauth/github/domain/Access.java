package com.cement.CodysseyBackend.domain.oauth.github.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "access")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "github_id")
    private String githubId;

    @Column(name = "access_token")
    private String accessToken;

    @Builder
    public Access (String githubId, String accessToken) {
        this.githubId = githubId;
        this.accessToken = accessToken;
    }
}
