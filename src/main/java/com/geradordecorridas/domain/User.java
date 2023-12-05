package com.geradordecorridas.domain;

public class User {
    private Id id;
    private String name;
    private String username;
    private String document;
    protected Account account;

    public User() {
    }

    public User(Id id, String name, String username, String document, Account account) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.document = document;
        this.account = account;
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getDocument() {
        return document;
    }

    public Account getAccount() {
        return account;
    }
}
