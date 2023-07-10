package com.cement.CodysseyBackend.domain.board.favorites.service;

import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.repository.StudyFavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyFavoritesService {

    private final StudyFavoritesRepository studyFavoritesRepository;

    public List<StudyFavorites> getMemberStudyFavorites(Long memberId) {
        List<StudyFavorites> studyFavoritesList = studyFavoritesRepository.findByMemberId(memberId);
        return studyFavoritesList;
    }

    public List<StudyFavorites> addMemberStudyFavorites(Long studyId, Long memberId) {
        StudyFavorites studyFavorites = StudyFavorites.builder()
                .studyId(studyId)
                .memberId(memberId)
                .build();
        studyFavoritesRepository.save(studyFavorites);
        return getMemberStudyFavorites(memberId);
    }

    public List<StudyFavorites> deleteMemberStudyFavorites(Long studyBookmarkId) {
        StudyFavorites studyFavorites = studyFavoritesRepository.findById(studyBookmarkId).get();
        Long memberId = studyFavorites.getMemberId();
        studyFavoritesRepository.deleteById(studyBookmarkId);
        List<StudyFavorites> studyFavoritesList = studyFavoritesRepository.findByMemberId(memberId);
        return studyFavoritesList;
    }
}
