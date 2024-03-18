package com.test.testframework.event;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<AbstractEvent> events = new ArrayList<>();

    public void add(AbstractEvent event) {
        if (hasScheduleConflictWith(event)) {
            return;
        }
        this.events.add(event);
    }
    public void printAll() {
        events.forEach(Event::print);
    }
    public void printBy(EventType type) {
        events.stream().filter(event->event.support(type)).forEach(Event::print);

    }

    private boolean hasScheduleConflictWith(AbstractEvent event){ // event를 순회하면서 하나라도 겹치는 시간대가 있는지 확인.
        return events.stream().anyMatch(each->(event.getStartAt().isBefore(each.getEndAt()) && event.getEndAt().isAfter(each.getStartAt()))
                ||(event.getEndAt().isAfter(each.getStartAt())&&event.getStartAt().isBefore(each.getEndAt())));
    }

}