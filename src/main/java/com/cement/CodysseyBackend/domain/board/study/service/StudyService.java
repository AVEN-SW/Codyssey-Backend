package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyUpdateRequest;
import com.cement.CodysseyBackend.domain.board.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
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

    public Study getStudy(Long id) {
        Study study = studyRepository.findById(id).get();
        return study;
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

    public Study closeStudy(Long studyId) {
        Study findStudy = studyRepository.findById(studyId).get();

        findStudy.setClosed(true);
        studyRepository.save(findStudy);
        findStudy = studyRepository.findById(studyId).get();
        return findStudy;
    }
}
