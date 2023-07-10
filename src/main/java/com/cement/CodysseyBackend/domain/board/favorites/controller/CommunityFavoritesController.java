package com.cement.CodysseyBackend.domain.board.favorites.controller;

import com.cement.CodysseyBackend.domain.board.favorites.domain.CommunityFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.dto.*;
import com.cement.CodysseyBackend.domain.board.favorites.service.CommunityFavoritesService;
import com.cement.CodysseyBackend.domain.board.favorites.service.StudyFavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites/community")
public class CommunityFavoritesController {

    private final CommunityFavoritesService communityFavoritesService;

    // TODO 멤버 즐겨찾기 검색 기능
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommunityFavorites> getMemberCommunityFavorites(@RequestBody GetCommunityFavoritesRequest request) {
            List<CommunityFavorites> communityFavoritesList = communityFavoritesService.getMemberCommunityFavorites(request.getMemberId());
            return communityFavoritesList;
    }

    // TODO 즐겨찾기 등록 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<CommunityFavorites> addMemberCommunityFavorites(@RequestBody AddCommunityFavoritesRequest request) {
        List<CommunityFavorites> communityFavoritesList = communityFavoritesService.addMemberCommunityFavorites(request.getCommunityId(), request.getMemberId());
        return communityFavoritesList;
    }

}
