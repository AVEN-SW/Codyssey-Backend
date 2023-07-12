package com.cement.CodysseyBackend.domain.meeting.controller;

import com.cement.CodysseyBackend.domain.meeting.domain.Meeting;
import com.cement.CodysseyBackend.domain.meeting.dto.MeetingCreateRequest;
import com.cement.CodysseyBackend.domain.meeting.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    // 미팅 생성 기능
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Meeting> createMeeting(@RequestBody MeetingCreateRequest request){
        
        return null;
    }

}
