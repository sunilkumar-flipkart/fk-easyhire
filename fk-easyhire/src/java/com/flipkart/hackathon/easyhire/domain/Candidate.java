package com.flipkart.hackathon.easyhire.domain;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Candidate {
    String id;
    String name;
    String email;
    Object resume;

    public Candidate(String name, String email, Object resume) {
        this.name = name;
        this.email = email;
        this.resume = resume;
    }

    public Candidate(String id, String name, String email, Object resume) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.resume = resume;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Object getResume() {
        return resume;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", resume=" + resume +
                '}';
    }
}
