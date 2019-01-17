package com.yazeed.service;

import com.yazeed.entity.UserEntity;
import com.yazeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userid){
        UserEntity userEntity = userRepository.findByUserid(userid);
        if (userEntity == null){
            throw new UsernameNotFoundException(userid);
        }
        return null;
    }
}
