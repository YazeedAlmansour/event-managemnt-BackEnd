package com.yazeed.repository;

import com.yazeed.entity.CommentEntity;
import com.yazeed.entity.EventEntity;
import com.yazeed.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> findByUserEntityfkAndIsdeletedIsFalse(UserEntity userEntity);

    Long countByEventEntityfkAndUserEntityfkAndLocalDateTimeIsAfter(EventEntity eventEntity,UserEntity userEntity, LocalDateTime localDateTime);

    List<CommentEntity> findByEventEntityfkAndIsdeletedIsFalse(EventEntity eventEntity);


}
