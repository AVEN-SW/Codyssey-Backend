package com.cement.CodysseyBackend.domain.member.repository;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
