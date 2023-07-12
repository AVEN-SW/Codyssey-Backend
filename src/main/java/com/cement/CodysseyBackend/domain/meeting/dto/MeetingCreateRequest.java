package com.cement.CodysseyBackend.domain.meeting.dto;


import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class MeetingCreateRequest {

    private Long locationId;
    private Long meetingLeader;
    private int maxPeople;
    private String meetingTitle;
    private String meetingContent;
    private String meetingType;

}
