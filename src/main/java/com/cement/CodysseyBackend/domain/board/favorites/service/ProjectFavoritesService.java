package com.cement.CodysseyBackend.domain.board.favorites.service;

import com.cement.CodysseyBackend.domain.board.favorites.repository.ProjectFavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectFavoritesService {

    private final ProjectFavoritesRepository projectFavoritesRepository;

    // 프로젝트 즐겨찾기 추가 기능

}
