package com.oatkachenko.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.sql.Date;

/**
 * Created by Home on 24.03.2016.
 */
public class UserDto {

    @Pattern(regexp = "[A-z0-9_-]{4,15}", message = "*4-15 symbols")
    private String username;

    @Length(min = 6, max = 15, message = "*6-15 symbols")
//    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "*повторите ввод")
    private String password;

    @Length(min = 6, max = 15, message = "*6-15 symbols")
    private String password2;


    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})", message = "*not valid email")
    private String email;


    private String firstName;

    private String lastName;

    private int age;

    private Date joined;
    private Date lastseen;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public Date getLastseen() {
        return lastseen;
    }

    public void setLastseen(Date lastseen) {
        this.lastseen = lastseen;
    }
}
