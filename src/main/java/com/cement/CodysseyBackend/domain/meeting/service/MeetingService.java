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

    // meeting 생성 기능
    public List<Meeting> makeMeeting(MeetingCreateRequest request){
        Meeting meeting = Meeting.builder()
                .locationId(request.getLocationId())
                .meetingLeader(request.getMeetingLeader())
                .maxPeople(request.getMaxPeople())
                .meetingContent(request.getMeetingContent())
                .meetingTitle(request.getMeetingTitle())
                .meetingType(request.getMeetingType())
                .build();

        meetingRepository.save(meeting);
        List<Meeting> meetings = meetingRepository.findAll();
        return meetings;
    }

}
