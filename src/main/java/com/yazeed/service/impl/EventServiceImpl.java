package com.yazeed.service.impl;

import com.yazeed.config.ObjectMapperUtils;
import com.yazeed.dto.EventDto;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.EventRepository;
import com.yazeed.repository.TicketRepository;
import com.yazeed.repository.UserRepository;
import com.yazeed.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public EmailServiceImpl emailService;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<EventEntity> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public EventDto getEvent(long eventid) {
        if (eventRepository.findById(eventid).isPresent()) {
            EventEntity eventEntity = eventRepository.findById(eventid).get();
            EventDto eventDto = modelMapper.map(eventEntity, EventDto.class);
            return eventDto;
        }
        return null;
    }

    @Override
    public ResponseEntity<EventEntity> addEvent(EventDto eventDto, long orgnaizerid) {
        if (userRepository.findById(orgnaizerid).isPresent()){
            Date date = Date.valueOf(LocalDate.now().minusDays(1));
            EventEntity eventEntity = modelMapper.map(eventDto,EventEntity.class);
            if (eventEntity.getEventdate().after(date)){
                eventEntity.setOrrgnaizerid(userRepository.findById(orgnaizerid).get());
                return ResponseEntity.ok(eventRepository.save(eventEntity));
            }
            return new ResponseEntity("Event date is before today's day", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Orgnaizer ID NOT FOUND", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<EventEntity> updateEvent(EventDto eventDto,long eventid) {
        if (eventRepository.findById(eventid).isPresent()){
            EventEntity tempEventEntity = eventRepository.findById(eventid).get();
            EventEntity eventEntity = modelMapper.map(eventDto,EventEntity.class);
            eventEntity.setOrrgnaizerid(tempEventEntity.getOrrgnaizerid());
            eventEntity.setEventnumber(eventid);
            eventRepository.save(eventEntity);
//            List<TicketEntity> ticketEntities = ticketRepository.findByEventidAndIsdeletedIsFalse(eventEntity);
//            for (TicketEntity ticketEntity:ticketEntities){
//                emailService.sendSimpleMessage(ticketEntity.getAttenderid().getUseremial(), "Hello","The Event " +eventEntity.getEventname()+ " was updated");
//            }
            return ResponseEntity.ok(eventEntity);
        }   return new ResponseEntity("Event ID NOT FOUND", HttpStatus.NOT_FOUND);


    }

    @Override
    public void deleteEvent(long eventid) {
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        eventEntity.setIsdeleted(true);
        eventRepository.save(eventEntity);
        List<TicketEntity> ticketEntities = ticketRepository.findByEventidAndIsdeletedIsFalse(eventEntity);
        for (TicketEntity ticketEntity:ticketEntities){
            emailService.sendSimpleMessage(ticketEntity.getAttenderid().getUseremial(), "Hello","The Event " +eventEntity.getEventname()+ " was deleted");
        }
    }

    @Override
    public List<EventDto> getOnlyApproved() {
        Date date = Date.valueOf(LocalDate.now().minusDays(1));
        List<EventEntity> eventEntities = eventRepository.findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateIsAfter(date);
        List<EventDto> eventDtos = ObjectMapperUtils.mapAll(eventEntities,EventDto.class);
        return eventDtos;
    }

    @Override
    public List<EventDto> getNotApproved() {
        Date date = Date.valueOf(LocalDate.now().minusDays(1));
        List<EventEntity> eventEntities = eventRepository.findByEventapprovalIsFalseAndIsdeletedIsFalseAndEventdateIsAfter(date);
        List<EventDto> eventDtos = ObjectMapperUtils.mapAll(eventEntities,EventDto.class);
        return eventDtos;
    }

    @Override
    public List<EventDto> getMyEvents(long orgnaizerid) {
        UserEntity userEntity = userRepository.findById(orgnaizerid).get();
        List<EventEntity> eventEntities = eventRepository.findByOrrgnaizeridAndIsdeletedIsFalse(userEntity);
        List<EventDto> eventDtos = ObjectMapperUtils.mapAll(eventEntities,EventDto.class);
        return eventDtos;
    }

    @Override
    public void approveEvent(long eventid) {
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        eventEntity.setEventapproval(true);
        eventRepository.save(eventEntity);
    }

    @Override
    public void rejectEvent(long eventid) {
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        eventEntity.setEventapproval(false);
        eventRepository.save(eventEntity);
    }


    @Override
    public List<EventEntity> searchByCity(String eventlocation) {
       return eventRepository.findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventlocationIn(eventlocation);
    }

    @Override
    public List<EventEntity> searchByDate(Date eventdatetime) {
        return eventRepository.findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateIn(eventdatetime);
    }

    @Override
    public List<EventEntity> searchByDateAndCity(Date eventdatetime, String eventlocation) {
        return eventRepository.findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateInAndEventlocationIn(eventdatetime,eventlocation);
    }


}
