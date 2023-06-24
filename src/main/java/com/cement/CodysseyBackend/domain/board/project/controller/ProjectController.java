package com.cement.CodysseyBackend.domain.board.project.controller;

import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectCreateRequest;
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

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectCreateRequest request){
        Project project = projectService.createProject(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> readProject(){
        List<Project> projectList = projectService.getProjectList();
        return ResponseEntity.ok().body(projectList);
    }



}
