package com.cement.CodysseyBackend.domain.member.repository;

import com.cement.CodysseyBackend.domain.member.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
