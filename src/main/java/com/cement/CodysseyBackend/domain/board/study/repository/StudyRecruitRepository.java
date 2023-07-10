package com.cement.CodysseyBackend.domain.board.study.repository;

import com.cement.CodysseyBackend.domain.board.study.domain.StudyRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRecruitRepository extends JpaRepository<StudyRecruit, Long> {
    List<StudyRecruit> findByStudyId(Long studyId);
}
