package com.yazeed.service;

import com.yazeed.dto.UserDto;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface UserService {



    List<UserDto> getAllUser();


    UserDto getUser(long userid);


    UserEntity addUser(UserDto userDto);


    void updateUser(UserDto userDto, long userid);


    void deleteUser(long userid);

    void enableUser(long userid);

    UserDto findByUserid(String userid);
}
