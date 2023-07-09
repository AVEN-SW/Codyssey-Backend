package com.cement.CodysseyBackend.domain.board.favorites.controller;

import com.cement.CodysseyBackend.domain.board.favorites.domain.ProjectFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.dto.AddProjectFavoritesRequest;
import com.cement.CodysseyBackend.domain.board.favorites.service.ProjectFavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites/project")
public class ProjectFavoritesController {

    private final ProjectFavoritesService projectFavoritesService;

    // 즐겨찾기 추가 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProjectFavorites> addFavorites(@RequestBody AddProjectFavoritesRequest request){

        List<ProjectFavorites> projectFavorites = projectFavoritesService.createFavorites(request);
        return projectFavorites;
    }
}
