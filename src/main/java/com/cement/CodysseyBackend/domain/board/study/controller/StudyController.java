package com.cement.CodysseyBackend.domain.board.study.controller;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyUpdateRequest;
import com.cement.CodysseyBackend.domain.board.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/study")
public class StudyController {

    private final StudyService studyService;

    // 스터디 생성 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Study createStudy(@RequestBody StudyCreateRequest request) {
        Study createdStudy = studyService.createStudy(request);
        return createdStudy;
    }


    // 스터디 목록 가져오기
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Study> getStudyList() {
        List<Study> studyList = studyService.getStudyList();
        return studyList;
    }

    // 스터디 정보 가져오기
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Study getStudy(@PathVariable("id") Long id) {
        Study study = studyService.getStudy(id);
        return study;
    }

    // 스터디 삭제 기능
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Study deleteStudy(@PathVariable("id") Long id) {
        Study study = studyService.deleteStudy(id);
        return study;
    }

    // 스터디 수정 기능
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Study updateStudy(@PathVariable("id") Long id,
                                             @RequestBody StudyUpdateRequest request) {
        Study updateStudy = studyService.updateStudy(id, request);

        return updateStudy;
    }

    // 스터디 마감 기능
    @PutMapping("/{id}/close")
    @ResponseStatus(HttpStatus.OK)
    public Study closeStudy(@PathVariable("id") Long id) {
        Study closedStudy = studyService.closeStudy(id);
        return closedStudy;
    }
}
