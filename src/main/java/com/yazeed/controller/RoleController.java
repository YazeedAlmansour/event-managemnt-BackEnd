package com.yazeed.controller;

import com.yazeed.entity.RoleEntity;
import com.yazeed.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roles")
    public List<RoleEntity> getAllRole(){
        return roleService.getAllRole();
    }

    @RequestMapping("/roles/{roleid}")
    public RoleEntity getRole(@PathVariable long roleid){
        return roleService.getRole(roleid);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/roles")
    public void addRole (@RequestBody RoleEntity roleEntity){
        roleService.addRole(roleEntity);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/roles/{roleid}")
    public void updateRole(@RequestBody RoleEntity roleEntity){
        roleService.updateRole(roleEntity);
    }
//    @RequestMapping(method = RequestMethod.PUT,value = "/roles/delete/{roleid}")
//    public void deleteRole(@PathVariable long roleid){
//        roleService.deleteRole(roleid);
//    }
}
