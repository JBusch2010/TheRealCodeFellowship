package com.joachen.CodeFellowship.models;

import javax.persistence.*;
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
    String createdAt;

    @ManyToOne
    ApplicationUser poster;

    public ApplicationUser getPoster() {
        return poster;
    }
    public Post() {}

    public Post (String body, ApplicationUser poster) {

        this.body = body;
        this.poster = poster;
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
