package com.cement.CodysseyBackend.domain.board.community.service;

import com.cement.CodysseyBackend.domain.board.community.domain.Community;
import com.cement.CodysseyBackend.domain.board.community.domain.LikeMember;
import com.cement.CodysseyBackend.domain.board.community.dto.CommunityCreateRequest;
import com.cement.CodysseyBackend.domain.board.community.dto.CommunityUpdateRequest;
import com.cement.CodysseyBackend.domain.board.community.dto.LikeCommunityRequest;
import com.cement.CodysseyBackend.domain.board.community.repository.CommunityRepository;
import com.cement.CodysseyBackend.domain.board.community.repository.LikeMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final LikeMemberRepository likeMemberRepository;

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

    public Community deleteCommunity(Long id) {
        Community findCommunity = communityRepository.findById(id).get();
        findCommunity.setDeleted(true);
        Community saveCommunity = communityRepository.save(findCommunity);
        return saveCommunity;
    }

    public Community updateCommunity(Long id, CommunityUpdateRequest request) {
        Community findCommunity = communityRepository.findById(id).get();
        findCommunity.setTitle(request.getTitle());
        findCommunity.setContent(request.getContent());
        findCommunity.setCategory(request.getCategory());

        Community updateCommunity = communityRepository.save(findCommunity);
        return updateCommunity;
    }

    public LikeMember likeCommunity(Long id, LikeCommunityRequest request) {

        // TODO 중복확인
        Optional<LikeMember> findLikeMember = likeMemberRepository.findByMemberIdAndCommunityIdAndFlag(request.getMemberId(), id, "Like");

        // 이미 좋아요를 누른 경우
        if (findLikeMember.isPresent()) {
            likeMemberRepository.deleteById(findLikeMember.get().getLikeId());
            return null;
        }

        LikeMember likeMember = LikeMember.builder()
                .memberId(request.getMemberId())
                .communityId(id)
                .flag("Like")
                .build();

        LikeMember saveLikeMember = likeMemberRepository.save(likeMember);
        return saveLikeMember;
    }
}
