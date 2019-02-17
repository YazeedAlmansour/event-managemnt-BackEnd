package com.yazeed.repository;

import com.yazeed.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserid(String userid);

    boolean existsByUserid(String userid);

    boolean existsByUseremial(String useremail);

    boolean existsByUsernumberAndEnabledIsTrue(long usernumber);

    boolean existsByUseridAndAndEnabledIsTrue(String userid);

}
