package com.yazeed.service;

import com.yazeed.entity.ReviewEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    List<ReviewEntity> getAllReview();


    ReviewEntity getReview(long reviewid);


    void addReview(ReviewEntity reviewEntity);


    void updateReview(ReviewEntity reviewEntity);


    void deleteReview(long reviewid);


    List<ReviewEntity> getReviews(long ticketid);


    ResponseEntity<ReviewEntity> reviewEvent(ReviewEntity reviewEntity ,long ticketid);
}
