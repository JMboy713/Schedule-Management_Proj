package com.test.testframework.event;

import java.time.ZonedDateTime;
import java.util.Set;

public class Meeting extends AbstractEvent{
    private Set<String> participants;
    private String meetingRoom;
    private String agenda;

    public Meeting(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt,Set<String> participants, String meetingRoom, String agenda) {
        super(id, title, startAt, endAt);
        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    @Override
    public void print() {
        System.out.printf("[회의]%s : %s%n", getTitle(), agenda); // 어떤 agenda에서 회의를 할것인지.
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.MEETING;
    }


}
