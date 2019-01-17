package com.yazeed.service;

import com.yazeed.entity.CommentEntity;
import com.yazeed.entity.EventEntity;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.util.List;

public interface CommentService {


    List<CommentEntity> getAllComment();

    List<CommentEntity> getComments(long eventid);



    ResponseEntity<CommentEntity> addComment(long userid, long eventid, CommentEntity commentEntity);

}

