package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyApplyRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyApplyService {

    private final StudyApplicantRepository studyApplicantRepository;

    public List<StudyApplicant> studyApply(Long studyId, StudyApplyRequest request) {
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
