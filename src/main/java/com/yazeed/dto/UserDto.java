package com.yazeed.dto;

import com.yazeed.entity.RoleEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

public class UserDto {

    @Id
    private long usernumber;

    @NotNull(message = "ID cannot be null")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Pattern(regexp = "[1-2]{1}+[0-9]{9}", message = "ID must start with 1 or 2 and 10 numbers")
    @Size(min = 10, max = 10, message = "ID must be 10 numbers")
    private String userid;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 10,message = "Last name must be betweem 2 to 10")
    @Pattern(regexp = "[a-zA-Z\\s]{2,10}", message = "Cannot have symbols or letters")
    private String userfname;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, max = 20,message = "Last name must be betweem 2 to 20")
    @Pattern(regexp = "[a-zA-Z\\s]{2,20}", message = "Cannot have symbols or letters")
    private String userlname;


    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Size(max = 36)
    @Email
    private String useremial;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 9, max = 9, message = "Phone must be 10 numbers")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Pattern(regexp = "[5]{1}+[0-9]{8}", message = "ID must start with 1 or 2 and 10 numbers")
    private String userphone;

    @NotNull(message = "Gender cannot be null")
    private String usergender;

    private Date userbirth;

    @NotNull(message = "Password cannot be null")
//    @Pattern(regexp = "[A-Za-z0-9]{8,15}", message = "Password can be numbers or letters")
    @Size(min = 8,message = "Password must be more than 8 digits and less than 15")
    private String password;

    private boolean enabled;

    private RoleEntity rolename;

    private String role;


    public long getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(long usernumber) {
        this.usernumber = usernumber;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserbirth(Date userbirth) {
        this.userbirth = userbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}