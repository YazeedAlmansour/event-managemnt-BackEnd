package com.yazeed.service;

import com.yazeed.dto.EventDto;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.RoleEntity;
import com.yazeed.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

public interface EventService {

    List<EventEntity> getAllEvent();


    EventDto getEvent(long eventid);


    ResponseEntity<EventEntity> addEvent(EventDto eventDto, long orgnaizerid);


    ResponseEntity<EventEntity> updateEvent(EventDto eventDto,long eventid);


    void deleteEvent(long eventid);


    List<EventDto> getOnlyApproved();


    List<EventDto> getNotApproved();


    List<EventDto> getMyEvents(long orgnaizerid);


    void approveEvent(long eventid);


    void rejectEvent(long eventid);


    List<EventEntity> searchByCity(String eventlocation);


    List<EventEntity> searchByDate(Date eventdatetime);


    List<EventEntity> searchByDateAndCity(Date eventdatetime,String eventlocation);




}
