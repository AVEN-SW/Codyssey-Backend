package com.cement.CodysseyBackend.domain.board.project.repository;

import com.cement.CodysseyBackend.domain.board.project.domain.ProjectApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectApplyRepository extends JpaRepository<ProjectApplicant, Long> {
    Optional<ProjectApplicant> findByProjectIdAndApplicantUserId(Long projectId, Long userId);
    List<ProjectApplicant> findByProjectId(Long projectId);
}
