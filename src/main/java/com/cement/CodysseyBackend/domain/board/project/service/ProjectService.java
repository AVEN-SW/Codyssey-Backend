package com.cement.CodysseyBackend.domain.board.project.service;

import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectCreateRequest;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectUpdateRequest;
import com.cement.CodysseyBackend.domain.board.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;


    public Project createProject(ProjectCreateRequest request){
        Project project = Project.builder()
                        .writerId(request.getWriterId())
                        .title(request.getTitle())
                        .content(request.getContent())
                        .frontNum(request.getFrontNum())
                        .backNum(request.getBackNum())
                        .designNum(request.getDesignNum())
                        .build();

        Project returnProject = projectRepository.save(project);
        return returnProject;
    }

    public List<Project> getProjectList(){
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    public Project updateProject(Long projectid, ProjectUpdateRequest request){
        Optional<Project> OptionalProject = projectRepository.findById(projectid);
        Project project = OptionalProject.get();
        project.setTitle(request.getTitle());
        project.setContent(request.getContent());
        project.setBackNum(request.getBackNum());
        project.setFrontNum(request.getFrontNum());
        project.setDesignNum(request.getDesignNum());

        return projectRepository.save(project);
    }

}
