package com.cement.CodysseyBackend.domain.board.favorites.repository;

import com.cement.CodysseyBackend.domain.board.favorites.domain.ProjectFavorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectFavoritesRepository extends JpaRepository<ProjectFavorites, Long> {

}
