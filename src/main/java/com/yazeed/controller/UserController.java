package com.yazeed.controller;

import com.yazeed.dto.UserDto;
import com.yazeed.entity.RoleEntity;
import com.yazeed.entity.UserEntity;
import com.yazeed.repository.RoleRepository;
import com.yazeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;




    @RequestMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }




    @RequestMapping("/user/{userid}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDto getUser(@PathVariable long userid){
        return userService.getUser(userid);
    }




    @RequestMapping(method = RequestMethod.POST,value = "/admin/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity addAdmin(@Valid @RequestBody UserDto userDto ,BindingResult result){
       if (result.hasErrors()){
           return ResponseEntity.badRequest().body(result.getAllErrors());
       }
        userDto.setRolename(roleRepository.findByRolename("ROLE_ADMIN"));
        return ResponseEntity.ok(userService.addUser(userDto));
    }




    @RequestMapping(method = RequestMethod.POST,value = "/user/add")
    public void addUser(@RequestBody @Valid  UserDto userDto ,BindingResult result){
        if (result.hasErrors()){
             ResponseEntity.badRequest().body(result.getAllErrors());
        }
         ResponseEntity.ok(userService.addUser(userDto));
    }




    @RequestMapping(method = RequestMethod.POST,value = "/organizer/add")
    public ResponseEntity addOrganizer(@Valid @RequestBody UserDto userDto ,BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        userDto.setRolename(roleRepository.findByRolename("ROLE_ORGANIZER"));
        return ResponseEntity.ok(userService.addUser(userDto));
    }




    @RequestMapping(method = RequestMethod.PUT, value = "/user/update/{userid}")
    public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto,@Valid @PathVariable long userid,BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        userService.updateUser(userDto,userid);
        return ResponseEntity.ok().build();
    }




    @RequestMapping(method = RequestMethod.DELETE,value = "/user/delete/{userid}")
    public void deleteUser(@PathVariable long userid){
        userService.deleteUser(userid);
    }




    @RequestMapping(method = RequestMethod.GET,value = "/user/enable/{userid}")
    public void enableUser(@PathVariable long userid){
        userService.enableUser(userid);
    }


}
