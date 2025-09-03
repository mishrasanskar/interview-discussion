package com.example.demo.MeetingScheduler;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MeetingRepo {

    private Map<Integer, List<MeetingEntity>> meetings = new HashMap<>();

    private static int meetingId = 1;

    public MeetingRepo(){
        createManualMeeting();
    }

    public List<MeetingEntity> queryFreeSlots(List<Integer> userIds){

        List<MeetingEntity> slots = new ArrayList<>();

        for(Integer userId : userIds){
            slots.addAll(meetings.get(userId));
        }

        int n = slots.size();

        slots.sort((a,b)-> Integer.compare(a.getStart(), b.getStart()));

        int st = slots.get(0).getStart();
        int en = slots.get(0).getEnd();

        List<MeetingEntity> freeSlots = new ArrayList<>();

        for(int i=1;i<slots.size();i++){

            if(slots.get(i).getStart() <= en){
                en = Math.max(en, slots.get(i).getEnd());
            }
            else{
                freeSlots.add(new MeetingEntity(1000, en, slots.get(i).getStart()));
                en = slots.get(i).getEnd();
            }
        }

        return freeSlots;
    }

    public void createManualMeeting(){

        meetings.putIfAbsent(1, new ArrayList<>());
        meetings.get(1).add(new MeetingEntity(1, 2,4));
        meetings.get(1).add(new MeetingEntity(1, 6,7));

        meetings.putIfAbsent(2, new ArrayList<>());
        meetings.get(2).add(new MeetingEntity(2, 3,5));
        meetings.get(2).add(new MeetingEntity(2, 6,8));
        //5-6
    }


    public void createMeeting(int creatingUserId, List<Integer> userIds, int start, int end){
        meetingId+=1;
        MeetingEntity newMeeting = new MeetingEntity(meetingId, start, end);

        for(int userId : userIds){

            if(userId != creatingUserId) {
                if (meetings.containsKey(userId)) {
                    meetings.get(userId).add(newMeeting);
                } else {
                    meetings.put(userId, new ArrayList<>());
                    meetings.get(userId).add(newMeeting);
                }
            }
        }
    }

}
