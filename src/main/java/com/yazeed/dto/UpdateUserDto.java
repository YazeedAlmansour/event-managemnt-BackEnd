package com.yazeed.dto;

import com.yazeed.entity.RoleEntity;

import javax.persistence.Id;
import java.sql.Date;

public class UpdateUserDto {


    @Id
    private long usernumber;

    private String userid;

    private String userfname;

    private String userlname;

    private String useremial;

    private String userphone;

    private String usergender;

    private Date userbirth;

    private boolean enabled;

    private RoleEntity rolename;

    private String role;


    public long getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(long usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUserlname() {
        return userlname;
    }

    public void setUserlname(String userlname) {
        this.userlname = userlname;
    }

    public String getUseremial() {
        return useremial;
    }

    public void setUseremial(String useremial) {
        this.useremial = useremial;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public Date getUserbirth() {
        return userbirth;
    }

    public void setUserbirth(Date userbirth) {
        this.userbirth = userbirth;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public RoleEntity getRolename() {
        return rolename;
    }

    public void setRolename(RoleEntity rolename) {
        this.rolename = rolename;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
