package com.geradordecorridas.domain;

public class Passenger extends User{
    public Passenger(Id id, String name, String username, String document, Account account) {
        super(id, name, username, document, account);
    }

    public static Passenger createPassenger(String name, String username, String document) {
        return new Passenger(
                Id.generateId(),
                name,
                username,
                document,
                new Account(Id.generateId())
        );
    }

    public void pay(Money value) {
        this.account.subtract(value);
    }

    public void requestRide() {

    }

    public void cancelRide() {

    }
}
