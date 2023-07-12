package com.cement.CodysseyBackend.domain.meeting.service;

import com.cement.CodysseyBackend.domain.meeting.domain.Meeting;
import com.cement.CodysseyBackend.domain.meeting.dto.MeetingCreateRequest;
import com.cement.CodysseyBackend.domain.meeting.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;


}
