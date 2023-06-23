package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    public Study createStudy(StudyCreateRequest request) {
        Study study = Study.builder()
                .writerId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .build();
        Study returnStudy = studyRepository.save(study);
        return returnStudy;
    }
}
