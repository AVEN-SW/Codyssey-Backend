package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyApplyRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCancelRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyApplicantRepository;
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
}
