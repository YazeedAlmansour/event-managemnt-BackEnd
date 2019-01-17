package com.yazeed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ROLE")
public class RoleEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ROLE_ID")
//    @JsonIgnore
//    private int roleid;

    @Id
    @Column(name = "rolename")
    @Size(max = 15)
    private String rolename;

//    @Column(name = "ROLE_ISDELETED")
//    @JsonIgnore
//    private boolean isdeleted;

//    public int getRoleid() {
//        return roleid;
//    }
//
//    public void setRoleid(int roleid) {
//        this.roleid = roleid;
//    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

//    public boolean isIsdeleted() {
//        return isdeleted;
//    }
//
//    public void setIsdeleted(boolean isdeleted) {
//        this.isdeleted = isdeleted;
//    }

    public RoleEntity(){

    }


}
