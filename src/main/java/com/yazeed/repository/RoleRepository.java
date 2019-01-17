package com.yazeed.repository;

import com.yazeed.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByRolename(String rolename);
}
