package com.yazeed.controller;


import com.yazeed.entity.CommentEntity;
import com.yazeed.entity.EventEntity;
import com.yazeed.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping("/comments")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CommentEntity> getAllComment(){
        return commentService.getAllComment();
    }



    @RequestMapping("/event/comment/{eventid}")
    public List<CommentEntity> getComments(@PathVariable long eventid){
        return commentService.getComments(eventid);
    }



    @RequestMapping(method = RequestMethod.POST, value = "/comment/{userid}/{eventid}")
    public ResponseEntity<CommentEntity> addComment(@Valid @PathVariable long userid, @Valid @PathVariable long eventid, @RequestBody CommentEntity commentEntity){
        return commentService.addComment(userid,eventid,commentEntity);
    }

}
