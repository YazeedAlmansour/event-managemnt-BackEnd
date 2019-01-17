package com.yazeed.controller;

import com.yazeed.dto.EventDto;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventConrtoller {

    @Autowired
    private EventService eventService;




    @RequestMapping("/events")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<EventEntity> getAllEvent(){
        return eventService.getAllEvent();
    }


    @RequestMapping("/myevents/{orgnaizerid}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public ResponseEntity getMyEvents(@PathVariable long orgnaizerid){
        return ResponseEntity.ok(eventService.getMyEvents(orgnaizerid));
    }


    @GetMapping("/event/{eventid}")
    public ResponseEntity getEvent(@PathVariable long eventid){
        return ResponseEntity.ok(eventService.getEvent(eventid));
    }




    @RequestMapping(method = RequestMethod.POST,value = "/event/add/{orgnaizerid}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public ResponseEntity addEvent (@Valid @RequestBody EventDto eventDto, @Valid @PathVariable long orgnaizerid, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }


        return eventService.addEvent(eventDto, orgnaizerid);
    }




    @RequestMapping(method = RequestMethod.PUT, value = "/event/update/{eventid}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public ResponseEntity updateEvent(@Valid @RequestBody EventDto eventDto,@Valid @PathVariable long eventid,BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(eventService.updateEvent(eventDto,eventid));
    }




    @RequestMapping(method = RequestMethod.GET,value = "/event/delete/{eventid}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public void deleteEvent(@PathVariable long eventid){
        eventService.deleteEvent(eventid);
    }




    @RequestMapping("/events/approved")
    public List<EventDto>getOnlyApproved(){
        return eventService.getOnlyApproved();
    }



    @RequestMapping("/events/notapproved")
    public List<EventDto> getNotApproved() { return eventService.getNotApproved(); }



        @RequestMapping(method = RequestMethod.GET,value = "/event/approve/{eventid}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void approveEvent(@PathVariable long eventid) {
        eventService.approveEvent(eventid);
    }




    @RequestMapping(method = RequestMethod.GET,value = "/event/reject/{eventid}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void rejectEvent(@PathVariable long eventid) {
        eventService.rejectEvent(eventid);
    }




    @RequestMapping("/events/search/city/{eventlocation}")
    public List<EventEntity> findByEventlocation(@PathVariable String eventlocation){
        return eventService.searchByCity(eventlocation);
    }




    @RequestMapping("/events/search/date/{eventdatetime}")
    public List<EventEntity> findByEventlocation(@PathVariable Date eventdatetime){
        return eventService.searchByDate(eventdatetime);
    }




    @RequestMapping("/events/search/dateAndCity/{eventdatetime}/{eventlocation}")
    public List<EventEntity> searchByDateAndCity(@PathVariable Date eventdatetime, @PathVariable String eventlocation){
        return eventService.searchByDateAndCity(eventdatetime,eventlocation);
    }




}
