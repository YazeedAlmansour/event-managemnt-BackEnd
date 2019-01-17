package com.yazeed.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "EVENT")
@Validated
public class EventEntity {

    @Id
    @Column(name = "EVENT_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventnumber;

    @Column(name = "EVENT_NAME")
    @NotNull(message = "Event name cannot be null")
    @Size(min = 2,max = 255)
    private String eventname;

    @Column(name = "EVENT_LOCATION")
    @NotNull(message = "Event location cannot be null")
    @Size(min = 2,max = 100)
    private String eventlocation;

    @Column(name = "EVENT_CAPACITY")
    @NotNull(message = "Event capacity cannot be null")
    @Max(value = 300,message = "Maximum Capacity is 300 ")
    private int eventcapacity;

    @Column(name = "EVENT_DATE")
    @NotNull(message = "Event date cannot be null")
    @DateTimeFormat
    private Date eventdate;

    @Column(name = "EVENT_TIME")
//    @NotNull(message = "Event Time cannot be null")
    @DateTimeFormat(pattern = "hh:mm:ss a")
    private String eventtime;

    @Column(name = "EVENT_APPROVAL")
    private boolean eventapproval;

    @Column(name = "EVENT_ISDELETED")
    private boolean isdeleted;

    @ColumnDefault("0")
    @Column(name = "EVENT_COUNTER")
    private int counter;



    /*====================RELATIONSHIP===================*/

    @OneToMany(mappedBy = "eventEntityfk",fetch = FetchType.EAGER)
    private List<CommentEntity> eventcomments;

    @ManyToOne
    @JoinColumn(name = "EVENT_ORGNAIZER_ID")
    private UserEntity orrgnaizerid;

    public UserEntity getOrrgnaizerid() {
        return orrgnaizerid;
    }

    public void setOrrgnaizerid(UserEntity orrgnaizerid) {
        this.orrgnaizerid = orrgnaizerid;
    }

    /*====================RELATIONSHIP===================*/

    public EventEntity(){

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

    public boolean isEventapproval() {
        return eventapproval;
    }

    public void setEventapproval(boolean eventapproval) {
        this.eventapproval = eventapproval;
    }

    public boolean isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<CommentEntity> getEventcomments() {
        return eventcomments;
    }

    public void setEventcomments(List<CommentEntity> eventcomments) {
        this.eventcomments = eventcomments;
    }
}
