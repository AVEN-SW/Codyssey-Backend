package com.cement.CodysseyBackend.domain.board.study.controller;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyApplyRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCancelRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyApplicantRepository;
import com.cement.CodysseyBackend.domain.board.study.service.StudyApplyService;
import com.cement.CodysseyBackend.domain.board.study.study;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/study/apply")
public class StudyApplyController {

    private final StudyApplyService studyApplyService;

    // 스터디 지원기능
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    // TODO 이미 지원되어 있는 경우 예외 처리
    public List<StudyApplicant> studyApply(@PathVariable("id") Long id,
                                           @RequestBody StudyApplyRequest request) {
        List<StudyApplicant> studyApplicants = studyApplyService.studyApply(id, request);
        return studyApplicants;
    }
    // TODO 스터디 지원 취소 기능
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyApplicant> studyCancelApply(@PathVariable("id") Long id,
                                                 @RequestParam Long userId) {
        List<StudyApplicant> studyApplicants = studyApplyService.studyCancel(id, userId);
        return studyApplicants;
    }
    // TODO 스터디 수락 기능
    @GetMapping("/{id}")
    public void studyAcceptApply(@PathVariable("id") Long id) {

    }

    // TODO 스터디 거절 기능
    @PutMapping("/{id}")    // 지원 Table을 수정 (멤버를 뺴냄)
    public void studyRefusalApply(@PathVariable("id") Long id) {

    }
}
