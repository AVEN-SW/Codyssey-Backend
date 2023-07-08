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


}
