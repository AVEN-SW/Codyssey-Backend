package com.cement.CodysseyBackend.domain.meeting.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Table(name = "meeting")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id", nullable = false)
    private Long meetingId;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "meeting_leader", nullable = false)
    private Long meetingLeader;

    @Column(name = "max_people", nullable = false)
    private int maxPeople;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "ended_at")
    private Timestamp endedAt;

    @Column(name = "is_end", nullable = false)
    private boolean isEnd;

    @Column(name = "meeting_title", nullable = false)
    private String meetingTitle;

    @Column(name = "meeting_content", nullable = false)
    private String meetingContent;

    @Column(name = "meeting_type", nullable = false)
    private String meetingType;

    @Builder
    public Meeting(Long locationId, Long meetingLeader, int maxPeople,
                   Timestamp createdAt, Timestamp endedAt, String meetingTitle,
                    String meetingContent, String meetingType){

        this.locationId = locationId;
        this.meetingLeader = meetingLeader;
        this.maxPeople = maxPeople;
        this.createdAt = createdAt;
        this.endedAt = endedAt;
        this.meetingTitle = meetingTitle;
        this.meetingContent = meetingContent;
        this.meetingType = meetingType;
        this.isEnd = false;

    }

}
