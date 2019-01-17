package com.yazeed.service.impl;

import com.yazeed.entity.EventEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.EventRepository;
import com.yazeed.repository.TicketRepository;
import com.yazeed.repository.UserRepository;
import com.yazeed.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public EmailServiceImpl emailService;


    @Override
    public List<TicketEntity> getAllTicket() {
        return (List<TicketEntity>) ticketRepository.findAll();
    }

    @Override
    public TicketEntity getTicket(long ticketid) {
        return ticketRepository.findById(ticketid).get();
    }

    @Override
    public void addTicket(TicketEntity ticketEntity) {
        ticketRepository.save(ticketEntity);
    }

    @Override
    public void updateTicket(TicketEntity ticketEntity) {
        ticketRepository.save(ticketEntity);
    }

    @Override
    public ResponseEntity deleteTicket(long ticketid) {
        if (ticketRepository.findById(ticketid).isPresent()){
            TicketEntity ticketEntity = ticketRepository.findById(ticketid).get();
            ticketEntity.setIsdeleted(true);
            ticketEntity.getEventid().setCounter(ticketEntity.getEventid().getCounter()-1);
            ticketRepository.save(ticketEntity);
//            emailService.sendSimpleMessage(ticketEntity.getAttenderid().getUseremial(), "Cancel Ticket","Your Ticket was canceled ");
            return ResponseEntity.ok().build();

        }
        return new ResponseEntity("Ticket ID NOT FOUND", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<TicketEntity> bookTicket(long userid, long eventid) {
        if (userRepository.findById(userid).isPresent()&&eventRepository.findById(eventid).isPresent()){
        TicketEntity ticketEntity = new TicketEntity();
        Date date = Date.valueOf(LocalDate.now().minusDays(1));
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        UserEntity userEntity = userRepository.findById(userid).get();
            if (ticketRepository.countByAttenderidAndTicketdateIn(userEntity,eventEntity.getEventdate())==1){
                throw new RuntimeException("You CANNOT book more than one ticket in the same day");
            }
            if(eventEntity.isEventapproval()&&!eventEntity.isIsdeleted()&&eventEntity.getEventdate().after(date)&&eventEntity.getCounter()<eventEntity.getEventcapacity()){
                ticketEntity.setEventid(eventRepository.findById(eventid).get());
                ticketEntity.setAttenderid(userRepository.findById(userid).get());
                ticketEntity.setEventname(eventEntity.getEventname());
                ticketEntity.setTicketdate(eventEntity.getEventdate());
                ticketEntity.setEventtime(eventEntity.getEventtime());
                eventEntity.setCounter((eventEntity.getCounter())+1);
                ticketRepository.save(ticketEntity);
//                emailService.sendSimpleMessage(ticketEntity.getAttenderid().getUseremial(), "New Ticket","Thank you for Registration in " +eventEntity.getEventname());
                return ResponseEntity.ok(ticketEntity);
            }
            throw new RuntimeException("Event is Not Active OR It's full");
        }
        throw new RuntimeException("User ID OR Event ID NOT FOUND");
    }

    @Override
    public List<TicketEntity> getMyTickets(long userid) {
        UserEntity userEntity = userRepository.findById(userid).get();
        return ticketRepository.findByAttenderidAndIsdeletedIsFalseAndTicketconformedIsFalse(userEntity);
    }

    @Override
    public List<TicketEntity> getMyAttendedTickets(long userid) {
        UserEntity userEntity = userRepository.findById(userid).get();
        return ticketRepository.findByAttenderidAndIsdeletedIsFalseAndTicketconformedIsTrue(userEntity);    }


    @Override
    public List<TicketEntity> getEventsTickets(long eventid) {
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        return ticketRepository.findByEventidAndIsdeletedIsFalse(eventEntity);
    }

    @Override
    public void conformTicket(long ticketid) {
        TicketEntity ticketEntity = ticketRepository.findById(ticketid).get();
        ticketEntity.setTicketconformed(true);
        ticketRepository.save(ticketEntity);
    }

    @Override
    public Long Count(long userid, long eventid) {
        UserEntity userEntity = userRepository.findById(userid).get();
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        return ticketRepository.countByAttenderidAndTicketdateIn(userEntity,eventEntity.getEventdate());
    }


}
