package com.example.demo.MeetingScheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeetingController {



    @Autowired
    private MeetingService meetingService;


    @GetMapping("/get-free-slots")
    public List<MeetingEntity> queryFreeSlots(@RequestBody List<Integer> userIds) {
        return meetingService.queryFreeSlots(userIds);
    }

    @PostMapping("/create-meeting")
    public void createMeeting(@RequestBody int creatingUserId, List<Integer> userIds, int start, int end){
        meetingService.createMeeting(creatingUserId, userIds, start, end);
    }

}
