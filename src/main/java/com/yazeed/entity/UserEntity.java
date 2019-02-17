package com.yazeed.entity;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Validated
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(name = "USER_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usernumber;

    @Column(unique = true)
    @NotNull(message = "ID cannot be null")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Pattern(regexp = "[1-2]{1}+[0-9]{9}", message = "ID must start with 1 or 2 and 10 numbers")
    @Size(min = 10,max = 10,message = "ID must be 10 numbers")
    private String  userid;

    @Column(name="USER_FNAME")
    @NotNull(message = "First name cannot be null")
    @Size(min = 2,max = 10 ,message = "Last name must be betweem 2 to 10")
    @Pattern(regexp = "[a-zA-Z\\s]{2,10}", message = "Cannot have symbols or letters")
    private String userfname;

    @Column(name="USER_LNAME")
    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, max = 20,message = "Last name must be betweem 2 to 20")
    @Pattern(regexp = "[a-zA-Z\\s]{2,20}", message = "Cannot have symbols or letters")
    private String userlname;

    @Column(name="USER_EMAIL",unique = true)
    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Size(max = 36)
    @Email
    private String useremial;

    @Column(name="USER_PHONE")
    @Size(min = 9, max = 9, message = "Phone must be 10 numbers")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
    @Pattern(regexp = "[5]{1}+[0-9]{8}", message = "ID must start with 1 or 2 and 10 numbers")
    private String userphone;

    @Column(name="USER_GENDER")
    @NotNull(message = "Gender cannot be null")
    private String usergender;

    @Column(name="USER_BIRTH")
    private Date userbirth;

    @Column(name="password")
    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "[^\\s]+" ,message = "Whitespace not accepted")
//    @Pattern(regexp = "[A-Za-z0-9]{8,15}", message = "Password can be numbers or letters")
    @Size(min = 8,message = "Password must be more than 8 digits and less than 15")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    /*====================RELATIONSHIP===================*/
    @ManyToOne
    @JoinColumn(name = "rolename",referencedColumnName ="rolename" )
    private RoleEntity rolename;

    public RoleEntity getRolename() {
        return rolename;
    }

    public void setRolename(RoleEntity rolename) {
        this.rolename = rolename;
    }
    /*====================RELATIONSHIP===================*/


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(long usernumber) {
        this.usernumber = usernumber;
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

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremial() {
        return useremial;
    }

    public void setUseremial(String useremial) {
        this.useremial = useremial;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserEntity(){

    }


}
