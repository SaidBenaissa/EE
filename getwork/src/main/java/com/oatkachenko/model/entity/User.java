package com.oatkachenko.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Oleg on 12.03.2016.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "Role")
    private Role role;
    @Column(name = "Joined")
    private Date joined;
    @Column(name = "Last_seen")
    private Date lastseen;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Task> taskListAsOwner;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "freelancers")
    @JsonManagedReference
    private Set<Task> taskListAsFreelancer;

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

    public Set<Task> getTaskListAsOwner() {
        return taskListAsOwner;
    }

    public void setTaskListAsOwner(Set<Task> taskListAsOwner) {
        this.taskListAsOwner = taskListAsOwner;
    }

    public Set<Task> getTaskListAsFreelancer() {
        return taskListAsFreelancer;
    }

    public void setTaskListAsFreelancer(Set<Task> taskListAsFreelancer) {
        this.taskListAsFreelancer = taskListAsFreelancer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public Date getLastseen() {
        return lastseen != null ? lastseen : null;
    }

    public void setLastseen(Date lastseen) {
        this.lastseen = lastseen;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", role=" + role +
                ", joined=" + joined +
                ", lastseen=" + lastseen +
                '}';
    }
}
