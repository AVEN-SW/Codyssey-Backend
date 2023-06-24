package com.cement.CodysseyBackend.domain.board.study.controller;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/study")
public class StudyController {

    private final StudyService studyService;

    @PostMapping
    public ResponseEntity<Study> createStudy(@RequestBody StudyCreateRequest request) {
        Study createdStudy = studyService.createStudy(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudy);
    }

    @GetMapping
    public ResponseEntity<List<Study>> getStudyList() {
        List<Study> studyList = studyService.getStudyList();
        return ResponseEntity.ok()
                .body(studyList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Study> deleteStudy(@PathVariable("id") Long id) {
        Study study = studyService.deleteStudy(id);
        return ResponseEntity.ok()
                .body(study);
    }
}
