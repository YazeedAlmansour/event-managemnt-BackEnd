package com.yazeed.service.impl;

import com.yazeed.entity.RoleEntity;
import com.yazeed.repository.RoleRepository;
import com.yazeed.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public List<RoleEntity> getAllRole() {
        List<RoleEntity> roleEntities = new ArrayList<>();
        roleRepository.findAll().forEach(roleEntities::add);
        return roleEntities;
    }

    @Override
    public RoleEntity getRole(long roleid) {
        return roleRepository.findById(roleid).get();
    }

    @Override
    public void addRole(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

//    @Override
//    public void deleteRole(long roleid) {
//
//        RoleEntity roleEntity = roleRepository.findById(roleid).get();
//        roleEntity.setIsdeleted(true);
//        roleRepository.save(roleEntity);;
//    }
}
