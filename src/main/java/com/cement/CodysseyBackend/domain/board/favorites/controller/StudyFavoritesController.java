package com.cement.CodysseyBackend.domain.board.favorites.controller;

import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.dto.AddStudyFavoritesRequest;
import com.cement.CodysseyBackend.domain.board.favorites.dto.DeleteStudyFavoritesRequest;
import com.cement.CodysseyBackend.domain.board.favorites.dto.GetStudyFavoritesRequest;
import com.cement.CodysseyBackend.domain.board.favorites.service.StudyFavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites/study")
public class StudyFavoritesController {

    private final StudyFavoritesService studyFavoritesService;

    // TODO 멤버 즐겨찾기 검색 기능
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudyFavorites> getMemberStudyFavorites(@RequestBody GetStudyFavoritesRequest request) {
            List<StudyFavorites> studyFavoritesList = studyFavoritesService.getMemberStudyFavorites(request.getMember_id());
            return studyFavoritesList;
    }
    // TODO 즐겨찾기 등록 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudyFavorites> addMemberStudyFavorites(@RequestBody AddStudyFavoritesRequest request) {
        List<StudyFavorites> studyFavoritesList = studyFavoritesService.addMemberStudyFavorites(request.getStudyId(), request.getMemberId());
        return studyFavoritesList;
    }
    
    // TODO 즐겨찾기 삭제 기능
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudyFavorites> deleteMemberStudyFavorites(@RequestBody DeleteStudyFavoritesRequest request) {
        List<StudyFavorites> studyFavoritesList = studyFavoritesService.deleteMemberStudyFavorites(request.getStudyFavoritesId());
        return studyFavoritesList;
    }

}
