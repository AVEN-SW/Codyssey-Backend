package com.cement.CodysseyBackend.domain.board.project.repository;

import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
