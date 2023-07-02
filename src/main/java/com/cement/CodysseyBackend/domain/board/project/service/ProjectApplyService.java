package com.cement.CodysseyBackend.domain.board.project.service;

import com.cement.CodysseyBackend.domain.board.project.domain.ProjectApplicant;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectApplyRequest;
import com.cement.CodysseyBackend.domain.board.project.repository.ProjectApplyRepository;
import com.cement.CodysseyBackend.domain.board.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectApplyService {

    private final ProjectApplyRepository projectApplyRepository;

    public ProjectApplicant applyProject(ProjectApplyRequest request){

       ProjectApplicant projectApplicant = ProjectApplicant.builder()
               .projectId(request.getProjectId())
               .applicantUserId(request.getApplicantUserId())
               .position(request.getPosition())
               .content(request.getContent())
               .build();

       ProjectApplicant returnProjectApplicant = projectApplyRepository.save(projectApplicant);
       return returnProjectApplicant;

    }

    public List<ProjectApplicant> cancelApplyProject(Long projectId, Long userId){
        Optional<ProjectApplicant> findProjectApplicant = projectApplyRepository.findByProjectIdAndApplicantUserId(projectId, userId);

        // 지원자가 없는경우
        if (findProjectApplicant.isEmpty()) {
            return null;
        }

        projectApplyRepository.delete(findProjectApplicant.get());
        List<ProjectApplicant> projectApplicants = projectApplyRepository.findByProjectId(projectId);
        return projectApplicants;
    }

}
