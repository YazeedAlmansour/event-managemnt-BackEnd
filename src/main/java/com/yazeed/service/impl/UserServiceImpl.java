package com.yazeed.service.impl;

import com.yazeed.config.ObjectMapperUtils;
import com.yazeed.dto.UserDto;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.RoleRepository;
import com.yazeed.repository.UserRepository;
import com.yazeed.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUser(){
        List<UserEntity> userEntities =userRepository.findAll();
        List<UserDto> userDtos = ObjectMapperUtils.mapAll(userEntities,UserDto.class);
        return userDtos;
    }

    @Override
    public UserDto getUser(long userid){
        UserEntity userEntity = userRepository.findById(userid).get();
        UserDto userDto = modelMapper.map(userEntity,UserDto.class);
//        userDto.setId(userEntity.getUsernumber());
        return userDto;
    }


    @Override
    public UserEntity addUser(UserDto userDto){
        if (!userRepository.existsByUserid(userDto.getUserid())){
            if (!userRepository.existsByUseremial(userDto.getUseremial())){
        userDto.setRolename(roleRepository.findByRolename(userDto.getRole()));
        UserEntity userEntity = modelMapper.map(userDto,UserEntity.class);
        String encoded=new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(encoded);
        return userRepository.save(userEntity);
            } throw new RuntimeException(userDto.getUseremial()+" already exist ");
        } throw new RuntimeException(userDto.getUserid()+" already exist ");
    }

    @Override
    public void updateUser(UserDto userDto, long userid) {
        if (userRepository.findById(userid).isPresent()){
            UserEntity tempUserEntity= userRepository.findById(userid).get();
            UserEntity userEntity = modelMapper.map(userDto,UserEntity.class);
            userEntity.setRolename(tempUserEntity.getRolename());
            userEntity.setUsernumber(userid);
            String encoded=new BCryptPasswordEncoder().encode(userEntity.getPassword());
            userEntity.setPassword(encoded);
            userEntity.setEnabled(true);
            userRepository.save(userEntity);
        }


    }

    @Override
    public void deleteUser(long userid) {
        UserEntity userEntity = userRepository.findById(userid).get();
        userEntity.setEnabled(false);
        userRepository.save(userEntity);


    }

    @Override
    public void enableUser(long userid) {
        UserEntity userEntity = userRepository.findById(userid).get();
        userEntity.setEnabled(true);
        userRepository.save(userEntity);
    }

    @Override
    public boolean isUserNumberEnabled(long usernumber) {
        return userRepository.existsByUsernumberAndEnabledIsTrue(usernumber);
    }

    @Override
    public boolean isUserIdEnabled(String userid) {
        return userRepository.existsByUseridAndAndEnabledIsTrue(userid);
    }

    @Override
    public UserDto findByUserid(String userid) {
        UserEntity userEntity = userRepository.findByUserid(userid);
        UserDto userDto = modelMapper.map(userEntity,UserDto.class);
        return userDto;
    }
}
