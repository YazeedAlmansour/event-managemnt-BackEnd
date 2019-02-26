package com.yazeed.service;

import com.yazeed.dto.UpdateUserDto;
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


    UpdateUserDto getUserUpdate(long userid);


    UserEntity addUser(UserDto userDto);


    void updateUser(UpdateUserDto updateUserDto, long userid);


    void deleteUser(long userid);

    void enableUser(long userid);

    boolean isUserNumberEnabled(long usernumber);

    boolean isUserIdEnabled(String userid);


    UserDto findByUserid(String userid);

    UserDto findByUserNumber(long usernumber);
}
