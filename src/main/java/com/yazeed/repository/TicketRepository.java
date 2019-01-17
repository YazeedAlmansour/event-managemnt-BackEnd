package com.yazeed.repository;

import com.yazeed.entity.EventEntity;
import com.yazeed.entity.TicketEntity;
import com.yazeed.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

    List<TicketEntity> findByAttenderidAndIsdeletedIsFalseAndTicketconformedIsFalse(UserEntity userEntity);

    List<TicketEntity> findByAttenderidAndIsdeletedIsFalseAndTicketconformedIsTrue(UserEntity userEntity);

    List<TicketEntity> findByEventidAndIsdeletedIsFalse(EventEntity eventEntity);

    Long countByAttenderidAndTicketdateIn(UserEntity userEntity,Date date);

}
