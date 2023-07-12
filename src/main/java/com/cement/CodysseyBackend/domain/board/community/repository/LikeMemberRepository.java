package com.cement.CodysseyBackend.domain.board.community.repository;

import com.cement.CodysseyBackend.domain.board.community.domain.LikeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeMemberRepository extends JpaRepository<LikeMember, Long> {
    Optional<LikeMember> findByMemberIdAndCommunityIdAndFlag(Long memberId, Long communityId, String flag);
}
