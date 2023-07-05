package com.cement.CodysseyBackend.domain.board.project.controller;

import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectCreateRequest;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectUpdateRequest;
import com.cement.CodysseyBackend.domain.board.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/project")
public class ProjectController {

    private final ProjectService projectService;

    // 프로젝트 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody ProjectCreateRequest request){
        Project project = projectService.createProject(request);
        return project;
    }

    // 프로젝트 목록 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> readProject(){
        List<Project> projectList = projectService.getProjectList();
        return projectList;
    }


    // 프로젝트 수정
    @PutMapping("/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public Project modifyProject(@PathVariable("projectId") Long projectId,
                                                 @RequestBody ProjectUpdateRequest request){
        Project project = projectService.updateProject(projectId, request);

        return project;
    }

    // 프로젝트 삭제
    @DeleteMapping("/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public Project deleteProject(@PathVariable("projectId") Long projectId) {
        Project project = projectService.deleteProject(projectId);
        return project;
    }
}
