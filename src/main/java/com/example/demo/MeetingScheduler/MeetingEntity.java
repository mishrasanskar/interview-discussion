package com.example.demo.MeetingScheduler;

public class MeetingEntity {

    private int meetingId;
    private int start;
    private int end;


    public MeetingEntity(int meetingId, int start, int end) {
        this.meetingId = meetingId;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

