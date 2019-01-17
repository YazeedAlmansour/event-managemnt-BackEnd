package com.yazeed.repository;

import com.yazeed.dto.EventDto;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateIsAfter(Date date);

    List<EventEntity> findByEventapprovalIsFalseAndIsdeletedIsFalseAndEventdateIsAfter(Date date);

    List<EventEntity> findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventlocationIn(String eventlocation);

    List<EventEntity> findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateIn(Date eventdate);

    List<EventEntity> findByEventapprovalIsTrueAndIsdeletedIsFalseAndEventdateInAndEventlocationIn(Date eventdate,String eventlocation);

    List<EventEntity> findByOrrgnaizeridAndIsdeletedIsFalse(UserEntity userEntity);

//    List<EventDto> findAll(List<EventDto> eventDtos);
}
