package com.cement.CodysseyBackend.domain.board.favorites.service;

import com.cement.CodysseyBackend.domain.board.favorites.domain.ProjectFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.dto.AddProjectFavoritesRequest;
import com.cement.CodysseyBackend.domain.board.favorites.repository.ProjectFavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectFavoritesService {

    private final ProjectFavoritesRepository projectFavoritesRepository;

    // 프로젝트 즐겨찾기 아이디별 조회
    public List<ProjectFavorites> findFavoritesById(Long memberId){
        List<ProjectFavorites> projectFavorites = projectFavoritesRepository.findByMemberId(memberId);

        return projectFavorites;
    }

    // 프로젝트 즐겨찾기 추가 기능
    public List<ProjectFavorites> createFavorites(AddProjectFavoritesRequest request){
        ProjectFavorites projectFavorite = ProjectFavorites.builder()
                .projectId(request.getProjectId())
                .memberId(request.getMemberId())
                .build();
        projectFavoritesRepository.save(projectFavorite);
        List<ProjectFavorites> projectFavorites = findFavoritesById(request.getMemberId());

        return projectFavorites;
    }
}
