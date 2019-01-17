package com.yazeed.controller;

import com.yazeed.entity.EventEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/tickets")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<TicketEntity> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @RequestMapping("/ticket/{ticketid}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TicketEntity getTicket(@PathVariable long ticketid) {
        return ticketService.getTicket(ticketid);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/ticket")
//    public void addTicket(@RequestBody TicketEntity ticketEntity) {
//        ticketService.addTicket(ticketEntity);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tickets/{ticketid}")
    public void updateTicket(@RequestBody TicketEntity ticketEntity, @PathVariable long ticketid) {
        ticketService.updateTicket(ticketEntity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/delete/{ticketid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity deleteTicket(@PathVariable long ticketid) {
        return ticketService.deleteTicket(ticketid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/conform/{ticketid}")
    @PreAuthorize("hasAnyRole('ROLE_ORGANIZER','ROLE_ADMIN')")
    public void conformTicket(@PathVariable long ticketid) {
        ticketService.conformTicket(ticketid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/{userid}/{eventid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity bookTicket(@PathVariable long userid, @PathVariable long eventid){
        return ticketService.bookTicket(userid,eventid);
    }

    @RequestMapping("/mytickets/{userid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TicketEntity> getMyTickets(@PathVariable long userid){
        return ticketService.getMyTickets(userid);
    }


    @RequestMapping("/mytickets/attended/{userid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TicketEntity> getMyAttendedTickets(@PathVariable long userid){
        return ticketService.getMyAttendedTickets(userid);
    }

    @RequestMapping("/events/tickets/{eventid}")
    @PreAuthorize("hasAnyRole('ROLE_ORGANIZER','ROLE_ADMIN')")
    public List<TicketEntity> getEventsTickets(@PathVariable long eventid){
        return ticketService.getEventsTickets(eventid);
    }



    @RequestMapping("/count/{userid}/{eventid}")
    public Long count(@PathVariable long userid,@PathVariable long eventid){
        return ticketService.Count(userid,eventid);
    }

}