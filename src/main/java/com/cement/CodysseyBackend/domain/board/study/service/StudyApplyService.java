package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyApplyRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyApplyService {

    private final StudyApplicantRepository studyApplicantRepository;

    public List<StudyApplicant> studyApply(Long studyId, StudyApplyRequest request) {

        Optional<StudyApplicant> findApplicant = studyApplicantRepository.findByStudyIdAndApplicantUserId(studyId, request.getApplicantUserId());

        // 객체가 있는 경우 이미 지원을 한 상태
        // 예외처리
        if(findApplicant.isPresent()) {
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
}
