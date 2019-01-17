package com.yazeed.service.impl;

import com.yazeed.entity.CommentEntity;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.CommentRepository;
import com.yazeed.repository.EventRepository;
import com.yazeed.repository.UserRepository;
import com.yazeed.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;



    @Override
    public List<CommentEntity> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentEntity> getComments(long eventid) {
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        return commentRepository.findByEventEntityfkAndIsdeletedIsFalse(eventEntity);
    }

    @Override
    public ResponseEntity<CommentEntity> addComment(long userid, long eventid, CommentEntity commentEntity) {
        if (userRepository.findById(userid).isPresent()&&eventRepository.findById(eventid).isPresent()){
        EventEntity eventEntity = eventRepository.findById(eventid).get();
        UserEntity userEntity = userRepository.findById(userid).get();
        LocalDateTime dateTime = LocalDateTime.now().minusSeconds(20);
            long counter = commentRepository.countByEventEntityfkAndUserEntityfkAndLocalDateTimeIsAfter(eventEntity,userEntity,dateTime);
            if (counter==0){
                commentEntity.setUserEntityfk(userEntity);
                commentEntity.setEventEntityfk(eventEntity);
                commentEntity.setLocalDateTime(LocalDateTime.now());
                commentRepository.save(commentEntity);
                return ResponseEntity.ok(commentEntity);
            }
            throw new RuntimeException("You should Wait 20 seconds to comment again");
        }
        throw new RuntimeException("User ID OR Event ID NOT FOUND");
    }

}
