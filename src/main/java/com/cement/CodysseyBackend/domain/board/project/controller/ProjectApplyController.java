package com.cement.CodysseyBackend.domain.board.project.controller;


import com.cement.CodysseyBackend.domain.board.project.domain.ProjectApplicant;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectApplyRequest;
import com.cement.CodysseyBackend.domain.board.project.service.ProjectApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/project/apply")
public class ProjectApplyController {

    private final ProjectApplyService projectApplyService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProjectApplicant applyProject(@RequestBody ProjectApplyRequest request){
        ProjectApplicant projectApplicant =
                projectApplyService.applyProject(request);

        return projectApplicant;

    }
}
