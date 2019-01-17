package com.yazeed.controller;

import com.yazeed.entity.ReviewEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/reviews")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<ReviewEntity> getAllReview(){
        return reviewService.getAllReview();
    }

    @RequestMapping("/reviews/{reviewid}")
    public ReviewEntity getReview(@PathVariable long reviewid){
        return reviewService.getReview(reviewid);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/reviews")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void addReview (@RequestBody ReviewEntity reviewEntity){
        reviewService.addReview(reviewEntity);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reviews/{reviewid}")
    public void updateReview(@RequestBody ReviewEntity reviewEntity,@PathVariable long reviewid){
            reviewService.updateReview(reviewEntity);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/reviews/delete/{reviewid}")
    public void deleteReview(@PathVariable long reviewid){
        reviewService.deleteReview(reviewid);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/review/{ticketid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ReviewEntity> reviewEvent(@RequestBody ReviewEntity reviewEntity ,@PathVariable long ticketid){
        return reviewService.reviewEvent(reviewEntity, ticketid);
    }

    @RequestMapping("/review/{ticketid}")
    public List<ReviewEntity> getReviews(@PathVariable long ticketid) {
        return reviewService.getReviews(ticketid);
    }
    }
