package com.yazeed.dto;

import com.yazeed.entity.CommentEntity;
import com.yazeed.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class EventDto {



    private long eventnumber;

    @NotNull(message = "Event name cannot be null")
    @Size(min = 2, max = 255)
    private String eventname;

    @NotNull(message = "Event location cannot be null")
    @Size(min = 2, max = 100)
    private String eventlocation;

    @NotNull(message = "Event capacity cannot be null")
    @Max(value = 300, message = "Maximum Capacity is 300 ")
    private int eventcapacity;

    @NotNull(message = "Event date cannot be null")
    private Date eventdate;

//    @NotNull(message = "Event Time cannot be null")
    private String eventtime;

    private boolean eventapproval;

    private int counter;

    private List<CommentEntity> eventcomments;

    private UserDto orrgnaizerid;

    private long orgid;

    public long getOrgid() {
        return orgid;
    }

    public void setOrgid(long orgid) {
        this.orgid = orgid;
    }

    public long getEventnumber() {
        return eventnumber;
    }

    public void setEventnumber(long eventnumber) {
        this.eventnumber = eventnumber;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public int getEventcapacity() {
        return eventcapacity;
    }

    public void setEventcapacity(int eventcapacity) {
        this.eventcapacity = eventcapacity;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public List<CommentEntity> getEventcomments() {
        return eventcomments;
    }

    public void setEventcomments(List<CommentEntity> eventcomments) {
        this.eventcomments = eventcomments;
    }

    public boolean isEventapproval() {
        return eventapproval;
    }

    public void setEventapproval(boolean eventapproval) {
        this.eventapproval = eventapproval;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public UserDto getOrrgnaizerid() {
        return orrgnaizerid;
    }

    public void setOrrgnaizerid(UserDto orrgnaizerid) {
        this.orrgnaizerid = orrgnaizerid;
    }
}
