package com.yazeed.service;

import com.yazeed.entity.EventEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {

    List<TicketEntity> getAllTicket();


    TicketEntity getTicket(long ticketid);


    void addTicket(TicketEntity ticketEntity);


    void updateTicket(TicketEntity ticketEntity);


    ResponseEntity deleteTicket(long ticketid);


    ResponseEntity<TicketEntity> bookTicket(long userid, long eventid);


    List<TicketEntity> getMyTickets(long userid);


    List<TicketEntity> getMyAttendedTickets(long userid);


    List<TicketEntity> getEventsTickets(long eventid);


    void conformTicket(long ticketid);


    Long Count(long userid, long eventid);
}
