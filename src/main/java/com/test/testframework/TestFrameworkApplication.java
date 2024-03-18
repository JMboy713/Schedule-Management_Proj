package com.test.testframework;

import com.test.testframework.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestFrameworkApplication {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        HashSet<String> participants = new HashSet<String>();
        participants.add("jason.kim");

        Meeting meeting1 =new Meeting(1,"회의1", ZonedDateTime.now(),ZonedDateTime.now().plusHours(4), participants,
                "meetingRoomA","스터디");
        schedule.add(meeting1);

        Todo todo1 = new Todo(2,"할일1",ZonedDateTime.now().plusHours(5),ZonedDateTime.now().plusHours(6),"스터디 준비하기");
        schedule.add(todo1);
        schedule.printBy(EventType.MEETING);
//        SpringApplication.run(TestFrameworkApplication.class, args);

        schedule.printAll();






    }

}
