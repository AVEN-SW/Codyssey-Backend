package com.cement.CodysseyBackend.domain.board.favorites.repository;

import com.cement.CodysseyBackend.domain.board.favorites.domain.CommunityFavorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityFavoritesRepository extends JpaRepository<CommunityFavorites, Long> {

    List<CommunityFavorites> findByMemberId(Long memberId);
}
