package com.yazeed.repository;

import com.yazeed.entity.ReviewEntity;
import com.yazeed.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByTicketidAndIsdeletedIsFalse(TicketEntity ticketEntity);

}
