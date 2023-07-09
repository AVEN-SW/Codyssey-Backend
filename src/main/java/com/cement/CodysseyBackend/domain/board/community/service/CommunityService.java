package com.cement.CodysseyBackend.domain.board.community.service;

import com.cement.CodysseyBackend.domain.board.community.domain.Community;
import com.cement.CodysseyBackend.domain.board.community.dto.CommunityCreateRequest;
import com.cement.CodysseyBackend.domain.board.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityService {

    private final CommunityRepository communityRepository;

    public Community createCommunity(CommunityCreateRequest request) {
        Community community = Community.builder()
                .writerId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .build();

        Community createdCommunity = communityRepository.save(community);
        return createdCommunity;
    }

    public List<Community> getCommunityList() {
        List<Community> communityList = communityRepository.findByIsDeleted(false);
        return communityList;
    }

    public Community getCommunity(Long id) {
        Community community = communityRepository.findById(id).get();
        return community;
    }
}
