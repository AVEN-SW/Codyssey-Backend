package com.cement.CodysseyBackend.domain.oauth.github;

import com.cement.CodysseyBackend.domain.oauth.github.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Long> {
    public Access findByAccessToken(String access_token);
}
