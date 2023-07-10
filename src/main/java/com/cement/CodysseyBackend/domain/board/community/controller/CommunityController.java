package com.cement.CodysseyBackend.domain.board.community.controller;

import com.cement.CodysseyBackend.domain.board.community.domain.Community;
import com.cement.CodysseyBackend.domain.board.community.dto.CommunityCreateRequest;
import com.cement.CodysseyBackend.domain.board.community.dto.CommunityUpdateRequest;
import com.cement.CodysseyBackend.domain.board.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/community")
public class CommunityController {

    private final CommunityService communityService;

    // TODO 게시글 작성 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Community createCommunity(@RequestBody CommunityCreateRequest request) {
        Community createdCommunity = communityService.createCommunity(request);
        return createdCommunity;
    }
    
    // TODO 게시글 목록 가져오기
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Community> getCommunityList() {
        List<Community> communityList = communityService.getCommunityList();
        return communityList;
    }

    // TODO 특정 게시글 확인
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Community getCommunity(@PathVariable("id") Long id) {
        Community community = communityService.getCommunity(id);
        return community;
    }

    // TODO 게시글 삭제 기능
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Community deleteCommunity(@PathVariable("id") Long id) {
        Community community = communityService.deleteCommunity(id);
        return community;
    }

    // TODO 게시글 수정 기능
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Community updateCommunity(@PathVariable("id") Long id,
                                        @RequestBody CommunityUpdateRequest request) {
        Community updateCommunity = communityService.updateCommunity(id, request);

        return updateCommunity;
    }

    // TODO 게시글 좋아요 기능
    // TODO 게시글 싫어요 기능
}
