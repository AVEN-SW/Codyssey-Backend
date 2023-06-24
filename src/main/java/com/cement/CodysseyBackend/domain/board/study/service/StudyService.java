package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyUpdateRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Study> getStudyList() {
        List<Study> studyList = studyRepository.findByIsDeleted(false);
        return studyList;
    }

    public Study deleteStudy(Long id) {
        // 삭제할 게시판 정보 가져오기
        Study findStudy = studyRepository.findById(id).get();
        // 멤버변수 변경
        findStudy.setDeleted(true);
        Study saveStudy = studyRepository.save(findStudy);
        return saveStudy;
    }

    public Study updateStudy(Long id, StudyUpdateRequest request) {
        Study findStudy = studyRepository.findById(id).get();
        findStudy.setTitle(request.getTitle());
        findStudy.setContent(request.getContent());
        findStudy.setCategory(request.getCategory());

        Study updateStudy = studyRepository.save(findStudy);

        return updateStudy;
    }
}
