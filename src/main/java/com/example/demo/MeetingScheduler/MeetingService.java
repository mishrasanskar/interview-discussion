package com.example.demo.MeetingScheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {


    @Autowired
    private MeetingRepo meetingRepo;

    public List<MeetingEntity> queryFreeSlots(List<Integer> userIds) {
        return meetingRepo.queryFreeSlots(userIds);
    }

    public void  createMeeting(int creatingUserId, List<Integer> userIds, int start, int end){
        meetingRepo.createMeeting(creatingUserId, userIds, start, end);
    }
}
