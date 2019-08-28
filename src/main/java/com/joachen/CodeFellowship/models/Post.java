package com.joachen.CodeFellowship.models;

import javax.persistence.*;
//import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

//post needs a body and a createdAt timestamp
//logged in user should be able to create a post
//a post should belong to the user that created it
//post should be visible on the user profile page

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String body;
//    int createdAt;

    @ManyToOne
    ApplicationUser poster;

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    //TODO
//    public int getCreatedAt() {
//        return createdAt;
//    }

    public Post (String body, int createdAt) {

        this.body = body;
//        this.createdAt = createdAt;
    }

    public Post (String body, int createdAt, ApplicationUser loggedInUser) {}


}
