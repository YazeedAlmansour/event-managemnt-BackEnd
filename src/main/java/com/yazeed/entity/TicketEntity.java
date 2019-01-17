package com.yazeed.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "TICKET")
public class TicketEntity {

    @Id
    @Column(name = "TICKET_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketnumber;

    @Column(name = "TICKET_CONFORMED")
    private boolean ticketconformed;

    @Column(name = "TICKET_ISDELETED")
    private boolean isdeleted;

    private Date ticketdate;

    private String eventname;

    private String eventtime;

    private int ticketRate;

    private String ticketComment;

    private boolean rated;
    /*====================RELATIONSHIP===================*/
    @ManyToOne
    @JoinColumn(name = "TICKET_ATTENDER_ID" ,referencedColumnName = "USER_NUMBER")
    private UserEntity attenderid;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "TICKET_EVENT_NUMBER")
    private EventEntity eventid;

    public UserEntity getAttenderid() {
        return attenderid;
    }

    public void setAttenderid(UserEntity attenderid) {
        this.attenderid = attenderid;
    }

    public EventEntity getEventid() {
        return eventid;
    }

    public void setEventid(EventEntity eventid) {
        this.eventid = eventid;
    }

    /*====================RELATIONSHIP===================*/

    public TicketEntity(){

    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public long getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(long ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public boolean isTicketconformed() {
        return ticketconformed;
    }

    public void setTicketconformed(boolean ticketconformed) {
        this.ticketconformed = ticketconformed;
    }

    public boolean isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(Date ticketdate) {
        this.ticketdate = ticketdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public int getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(int ticketRate) {
        this.ticketRate = ticketRate;
    }

    public String getTicketComment() {
        return ticketComment;
    }

    public void setTicketComment(String ticketComment) {
        this.ticketComment = ticketComment;
    }
}
