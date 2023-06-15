package com.ograeset.talkbackend.model;

import jakarta.persistence.*;
@Table(name = "entries")
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String replyOne;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, getters, and setters

    public Entry() {
    }

    public Entry(String replyOne, String replyTwo, String replyThree, User user) {
        this.replyOne = replyOne;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplyOne() {
        return replyOne;
    }

    public void setReplyOne(String replyOne) {
        this.replyOne = replyOne;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}