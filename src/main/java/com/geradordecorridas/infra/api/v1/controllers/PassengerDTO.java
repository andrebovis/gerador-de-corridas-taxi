package com.geradordecorridas.infra.api.v1.controllers;

public class PassengerDTO {
    private String name;
    private String username;
    private String document;


    public PassengerDTO(String name, String username, String document) {
        this.name = name;
        this.username = username;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
