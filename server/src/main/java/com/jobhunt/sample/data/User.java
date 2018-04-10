package com.jobhunt.sample.data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_name")
    @Size(min = 10, max = 250, message = "User name exceeds maximum character")
    private String userName;

    @NotEmpty(message = "First name cannot be null")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null")
    @Column(name="last_name")
    private String lastName;

    @Size(max = 50)
    @NotEmpty(message="Email Address is required")
    @Email(message="must be a valid Email Address")
    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
