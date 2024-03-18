package com.test.testframework;

import com.test.testframework.event.AbstractEvent;
import com.test.testframework.event.Event;
import com.test.testframework.event.Meeting;
import com.test.testframework.event.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class TestFrameworkApplication {

    public static void main(String[] args) {
        List<AbstractEvent> list = new ArrayList<>();
        HashSet<String> participants = new HashSet<String>();
        participants.add("jason.kim");

        Meeting meeting1 =new Meeting(1,"회의1", ZonedDateTime.now(),ZonedDateTime.now().plusHours(1), participants,
                "meetingRoomA","스터디");
        list.add(meeting1);

        Todo todo1 = new Todo(2,"할일1",ZonedDateTime.now(),ZonedDateTime.now().plusHours(1),"스터디 준비하기");
        list.add(todo1);
        list.stream().forEach(Event::print);
//        SpringApplication.run(TestFrameworkApplication.class, args);



    }

}
