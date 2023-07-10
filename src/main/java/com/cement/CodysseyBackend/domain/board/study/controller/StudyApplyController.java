package com.cement.CodysseyBackend.domain.board.study.controller;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyRecruit;
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
    @PostMapping("/{id}/apply")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyApplicant> studyApply(@PathVariable("id") Long id,
                                           @RequestBody StudyApplyRequest request) {
        List<StudyApplicant> studyApplicants = studyApplyService.studyApply(id, request);
        return studyApplicants;
    }
    // 스터디 지원 취소 기능
    @DeleteMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyApplicant> studyCancelApply(@PathVariable("id") Long id,
                                                 @RequestParam Long userId) {
        List<StudyApplicant> studyApplicants = studyApplyService.studyCancel(id, userId);
        return studyApplicants;
    }
    // 스터디 수락 기능
    @GetMapping("/{id}/accept")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyRecruit> studyAcceptApply(@PathVariable("id") Long id,
                                               @RequestParam Long userId) {
        List<StudyRecruit> studyRecruits = studyApplyService.studyAccept(id, userId);
        return studyRecruits;
    }

    // 스터디 거절 기능
    @DeleteMapping("/{id}/refusal")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyApplicant> studyRefusalApply(@PathVariable("id") Long id,
                                  @RequestParam Long userId) {
        List<StudyApplicant> studyRecruits = studyApplyService.studyRefusal(id, userId);
        return studyRecruits;
    }

    // 스터디 지원자 목록 보기
    @GetMapping("/{id}/applicant-list")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyApplicant> studyApplicantList(@PathVariable("id") Long id) {
        List<StudyApplicant> applicants = studyApplyService.studyApplicantList(id);
        return applicants;
    }

    // 스터디 확정 멤버 목록 보기
    @GetMapping("/{id}/recruit-list")
    @ResponseStatus(HttpStatus.OK)
    public List<StudyRecruit> studyRecruitList(@PathVariable("id") Long id) {
        List<StudyRecruit> recruits = studyApplyService.studyRecruitList(id);
        return recruits;
    }
}
