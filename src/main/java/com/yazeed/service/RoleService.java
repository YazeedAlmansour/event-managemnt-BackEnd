package com.yazeed.service;

import com.yazeed.entity.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> getAllRole();


    RoleEntity getRole(long roleid);


    void addRole(RoleEntity roleEntity);


    void updateRole(RoleEntity roleEntity);


//    void deleteRole(long roleid);

}
