package com.test.testframework;

import com.test.testframework.event.Meeting;
import com.test.testframework.event.Schedule;
import com.test.testframework.reader.EventCsvReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TestFrameworkApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();
        EventCsvReader csvReader = new EventCsvReader();

        String meetingCsvPath = "/data/meeting.csv";


        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);




//        HashSet<String> participants = new HashSet<String>();
//        participants.add("jason.kim");
//
//        Meeting meeting1 =new Meeting(1,"회의1", ZonedDateTime.now(),ZonedDateTime.now().plusHours(4), participants,
//                "meetingRoomA","스터디");
//        schedule.add(meeting1);
//
//        Todo todo1 = new Todo(2,"할일1",ZonedDateTime.now().plusHours(5),ZonedDateTime.now().plusHours(6),"스터디 준비하기");
//        schedule.add(todo1);
//        schedule.printBy(EventType.MEETING);
////        SpringApplication.run(TestFrameworkApplication.class, args);
//
        schedule.printAll();






    }

}
