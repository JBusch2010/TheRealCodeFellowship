package com.joachen.CodeFellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    String dateOfBirth;
    String bio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "poster")
    List<Post> post;

    public ApplicationUser(String username, String password, String firstname, String lastname, String dateOfBirth, String bio){

        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    ApplicationUser(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return null;
    }

    @Override
    public String getPassword () {
        return this.password;
    }

    @Override
    public String getUsername () {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }

    public String getBio () {
        return bio;
    }

    public String getDateOfBirth () {
        return dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public List<Post> getPost() {
        return this.post;
    }
}
