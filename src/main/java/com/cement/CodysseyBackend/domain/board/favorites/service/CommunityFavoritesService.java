package com.cement.CodysseyBackend.domain.board.favorites.service;

import com.cement.CodysseyBackend.domain.board.community.domain.Community;
import com.cement.CodysseyBackend.domain.board.favorites.domain.CommunityFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.repository.CommunityFavoritesRepository;
import com.cement.CodysseyBackend.domain.board.favorites.repository.StudyFavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityFavoritesService {

    private final CommunityFavoritesRepository communityFavoritesRepository;

    public List<CommunityFavorites> getMemberCommunityFavorites(Long memberId) {
        List<CommunityFavorites> communityFavoritesList = communityFavoritesRepository.findByMemberId(memberId);
        return communityFavoritesList;
    }

    public List<CommunityFavorites> addMemberCommunityFavorites(Long communityId, Long memberId) {
        CommunityFavorites communityFavorites = CommunityFavorites.builder()
                .communityId(communityId)
                .memberId(memberId)
                .build();
        communityFavoritesRepository.save(communityFavorites);
        return getMemberCommunityFavorites(memberId);
    }

    public List<CommunityFavorites> deleteMemberCommunityFavorites(Long communityFavoritesId) {
        CommunityFavorites communityFavorites = communityFavoritesRepository.findById(communityFavoritesId).get();
        Long memberId = communityFavorites.getMemberId();
        communityFavoritesRepository.deleteById(communityFavoritesId);
        List<CommunityFavorites> communityFavoritesList = communityFavoritesRepository.findByMemberId(memberId);
        return communityFavoritesList;
    }
}
