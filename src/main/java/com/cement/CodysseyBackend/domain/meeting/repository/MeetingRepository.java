package com.cement.CodysseyBackend.domain.meeting.repository;

import com.cement.CodysseyBackend.domain.meeting.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
