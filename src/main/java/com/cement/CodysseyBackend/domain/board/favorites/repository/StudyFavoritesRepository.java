package com.cement.CodysseyBackend.domain.board.favorites.repository;

import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyFavoritesRepository extends JpaRepository<StudyFavorites, Long> {
    List<StudyFavorites> findByMemberId(Long memberId);
}
