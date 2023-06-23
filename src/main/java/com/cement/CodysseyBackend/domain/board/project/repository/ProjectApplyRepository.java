package com.cement.CodysseyBackend.domain.board.project.repository;

import com.cement.CodysseyBackend.domain.board.project.domain.ProjectApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectApplyRepository extends JpaRepository<ProjectApplicant, Long> {


}
