package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyRecruit;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyApplyRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCancelRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyApplicantRepository;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyRecruitRepository;
import com.cement.CodysseyBackend.domain.board.study.study;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyApplyService {

    private final StudyApplicantRepository studyApplicantRepository;
    private final StudyRecruitRepository studyRecruitRepository;

    public List<StudyApplicant> studyApply(Long studyId, StudyApplyRequest request) {

        Optional<StudyApplicant> findApplicant = studyApplicantRepository.findByStudyIdAndApplicantUserId(studyId, request.getApplicantUserId());

        // 객체가 있는 경우 이미 지원을 한 상태
        // 예외처리
        if (findApplicant.isPresent()) {
            // 임시 반환
            return null;
        }

        StudyApplicant studyApplicant = StudyApplicant.builder()
                                            .studyId(studyId)
                                            .applicantUserId(request.getApplicantUserId())
                                            .content(request.getContent())
                                            .build();
        studyApplicantRepository.save(studyApplicant);
        List<StudyApplicant> studyApplicants = studyApplicantRepository.findByStudyId(studyId);
        return studyApplicants;
    }

    public List<StudyApplicant> studyCancel(Long studyId, Long userId) {

        Optional<StudyApplicant> findApplicant = studyApplicantRepository.findByStudyIdAndApplicantUserId(studyId, userId);

        // 예외처리
        // 지원하지 않았는데 취소를 요청한 경우
        if (findApplicant.isEmpty()) {
            return null;
        }

        studyApplicantRepository.deleteByStudyIdAndApplicantUserId(studyId, userId);
        List<StudyApplicant> findApplicants = studyApplicantRepository.findByStudyId(studyId);

        return findApplicants;
    }

    public List<StudyRecruit> studyAccept(Long studyId, Long userId) {

        // 예외처리
        // 유저가 지원하지 않은 경우
        Optional<StudyApplicant> findApplicant = studyApplicantRepository.findByStudyIdAndApplicantUserId(studyId, userId);
        if (findApplicant.isEmpty()) {
            return null;
        }

        // 확정 멤버 테이블에 추가
        StudyRecruit studyRecruit = StudyRecruit.builder()
                .studyId(studyId)
                .recruitUserId(userId)
                .build();
        studyRecruitRepository.save(studyRecruit);

        List<StudyRecruit> findRecruits = studyRecruitRepository.findByStudyId(studyId);

        // 지원자 테이블에서 삭제
        studyCancel(studyId, userId);

        return findRecruits;
    }

    public List<StudyApplicant> studyRefusal(Long studyId, Long userId) {

        // 예외 처리
        // 유저가 지원하지 않은 경우
        Optional<StudyApplicant> findApplicant = studyApplicantRepository.findByStudyIdAndApplicantUserId(studyId, userId);
        if (findApplicant.isEmpty()) {
            return null;
        }

        // 지원자 테이블에서 삭제
        studyCancel(studyId, userId);

        List<StudyApplicant> findApplicants = studyApplicantRepository.findByStudyId(studyId);
        return findApplicants;
    }
}
