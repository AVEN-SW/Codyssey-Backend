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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Study createStudy(@RequestBody StudyCreateRequest request) {
        Study createdStudy = studyService.createStudy(request);
        return createdStudy;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Study> getStudyList() {
        List<Study> studyList = studyService.getStudyList();
        return studyList;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Study deleteStudy(@PathVariable("id") Long id) {
        Study study = studyService.deleteStudy(id);
        return study;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Study updateStudy(@PathVariable("id") Long id,
                                             @RequestBody StudyUpdateRequest request) {
        Study updateStudy = studyService.updateStudy(id, request);

        return updateStudy;
    }
}
