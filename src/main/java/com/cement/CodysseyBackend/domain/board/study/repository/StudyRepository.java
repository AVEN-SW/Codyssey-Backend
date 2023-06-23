package com.cement.CodysseyBackend.domain.board.study.repository;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
}
