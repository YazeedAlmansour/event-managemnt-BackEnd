package com.yazeed.service.impl;

import com.yazeed.entity.ReviewEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.repository.ReviewRepository;
import com.yazeed.repository.TicketRepository;
import com.yazeed.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public List<ReviewEntity> getAllReview() {
        return (List<ReviewEntity>) reviewRepository.findAll();
    }

    @Override
    public ReviewEntity getReview(long reviewid) {
        return reviewRepository.findById(reviewid).get();
    }

    @Override
    public void addReview(ReviewEntity reviewEntity) {
        reviewRepository.save(reviewEntity);
    }

    @Override
    public void updateReview(ReviewEntity reviewEntity) {
        reviewRepository.save(reviewEntity);
    }

    @Override
    public void deleteReview(long reviewid) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewid).get();
        reviewEntity.setIsdeleted(true);
        reviewRepository.save(reviewEntity);;;
    }

    @Override
    public List<ReviewEntity> getReviews(long ticketid) {
        TicketEntity ticketEntity = ticketRepository.findById(ticketid).get();
        return reviewRepository.findByTicketidAndIsdeletedIsFalse(ticketEntity);
    }

    @Override
    public ResponseEntity<ReviewEntity> reviewEvent(ReviewEntity reviewEntity ,long ticketid) {
        if (ticketRepository.findById(ticketid).isPresent()){
            TicketEntity ticketEntity = ticketRepository.findById(ticketid).get();
            if (ticketEntity.isTicketconformed()) {
                ticketEntity.setRated(true);
                ticketEntity.setTicketRate(reviewEntity.getReviewrate());
                ticketEntity.setTicketComment(reviewEntity.getReviewcommet());
                reviewEntity.setTicketid(ticketEntity);
                reviewRepository.save(reviewEntity);
                return ResponseEntity.ok(reviewEntity);
            } else {
                throw new RuntimeException("Ticket is NOT Conformed");
            }
        }
        throw new RuntimeException("Ticket ID NOT FOUND");
    }

}
