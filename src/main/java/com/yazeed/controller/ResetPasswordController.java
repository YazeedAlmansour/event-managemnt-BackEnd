package com.yazeed.controller;

import com.yazeed.dto.UserDto;
import com.yazeed.entity.ResetPasswordEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.UserRepository;
import com.yazeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResetPasswordController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/resetPassword/{usernumber}")
    public ResponseEntity resetPassword(@RequestBody ResetPasswordEntity resetPasswordEntity,@PathVariable long usernumber){
        UserEntity userEntity = userRepository.findById(usernumber).get();
        if (new BCryptPasswordEncoder().matches(resetPasswordEntity.getOldPassword(), userEntity.getPassword())){
            String encoded=new BCryptPasswordEncoder().encode(resetPasswordEntity.getNewPassword());
            userEntity.setPassword(encoded);
            userRepository.save(userEntity);
            return ResponseEntity.ok().build();

        }
        throw new RuntimeException("Password does not match");
    }
}
