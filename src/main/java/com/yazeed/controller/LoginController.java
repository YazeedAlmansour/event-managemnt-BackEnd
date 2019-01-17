package com.yazeed.controller;


import com.yazeed.service.UserService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/userData")
    public ResponseEntity login(Principal principal){
        Map<String, String> map = new HashMap<>();
        map.put("usernumber", String.valueOf(userService.findByUserid(principal.getName()).getUsernumber()));
        map.put("rolename", userService.findByUserid(principal.getName()).getRolename().getRolename());
        return ResponseEntity.ok(map);
    }
}
