package com.cement.CodysseyBackend.domain.board.study.repository;

import com.cement.CodysseyBackend.domain.board.study.domain.StudyApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyApplicantRepository extends JpaRepository<StudyApplicant, Long> {
    List<StudyApplicant> findByStudyId(Long studyId);
    Optional<StudyApplicant> findByStudyIdAndApplicantUserId(Long studyId, Long applicantUserId);
    void deleteByStudyIdAndApplicantUserId(Long studyId, Long applicantUserId);
}
