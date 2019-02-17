package com.yazeed.controller;


import com.yazeed.dto.UserDto;
import com.yazeed.entity.LoginEntity;
import com.yazeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;


//    @GetMapping("/userData")
//    public ResponseEntity login(Principal principal){
//        Map<String, String> map = new HashMap<>();
//        map.put("usernumber", String.valueOf(userService.findByUserid(principal.getName()).getUsernumber()));
//        map.put("rolename", userService.findByUserid(principal.getName()).getRolename().getRolename());
//        return ResponseEntity.ok(map);
//    }

    @PostMapping("/userData")
    public ResponseEntity login(@RequestBody LoginEntity loginEntity){
        if (!userService.isUserIdEnabled(loginEntity.getUserid())){
            throw new RuntimeException("User login failed");
        }
        UserDto userDto = userService.findByUserid(loginEntity.getUserid());
        if (userService.isUserNumberEnabled(userDto.getUsernumber()) && new BCryptPasswordEncoder().matches(loginEntity.getPassword(), userDto.getPassword())){
            Map<String, Object> map = new HashMap<>();
             map.put("usernumber", userDto.getUsernumber());
             map.put("rolename", userService.findByUserid(loginEntity.getUserid()).getRolename().getRolename());
             return ResponseEntity.ok(map);
        } else {
            throw new RuntimeException("Password incorrect");
        }
    }
}
