package com.test.testframework.event;

import com.test.testframework.exception.InvalidEventException;

import java.time.Duration;
import java.time.ZonedDateTime;

public class AbstractEvent implements Event{
    private final int id;
    private String title;
    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    private final ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;

    private boolean deletedYn;

    protected AbstractEvent(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        if (startAt.isAfter(endAt)) {throw new InvalidEventException(String.format("시작시간(%s)이 종료시간(%s)보다 늦을 수 없습니다.", startAt, endAt));}


        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);
        this.createdAt = ZonedDateTime.now();
        this.modifiedAt = ZonedDateTime.now();
        this.deletedYn = false;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public void print() {

    }

    @Override
    public boolean support(EventType type) {
        return false;
    }
    public void validateAndUpdate(){
        if(deletedYn==true){
            throw new InvalidEventException("이미 삭제된 일정입니다.");
        }
        defaultUpdate();
        update();

    }

    protected abstract void update();  // 각 이벤트에 맞에 해야함. -> 구현체에서 함





    private void defaultUpdate() {
        this.title;
        this.startAt;
        this.endAt;
        this.duration = Duration.between(startAt, endAt);
        this.modifiedAt = ZonedDateTime.now();
    }



}
