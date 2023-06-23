package com.cement.CodysseyBackend.domain.board.project.service;

import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectCreateRequest;
import com.cement.CodysseyBackend.domain.board.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                        .designNum(request.getFrontNum())
                        .build();


        Project returnProject = projectRepository.save(project);
        return returnProject;
    }

//    public List<> getProjectList(){
//
//    }

}
