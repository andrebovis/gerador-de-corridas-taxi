package com.geradordecorridas.domain;

public class Driver extends User{

    public Driver(Id id, String name, String username, String document, Account account) {
        super(id, name, username, document, account);
    }

    public void receivePayment(Money value) {
        this.account.add(value);
    }
    public void withdraw(Money value) {
        if (value.getValue().compareTo(value.getValue()) >= 0) this.account.subtract(value);
        else throw new RuntimeException("Saldo insuficiente.");
    }

    public static Driver createNewDriver() {
        return new Driver(
                Id.generateId(),
                "Fulano",
                "fulano_driver",
                "01234567891",
                new Account(
                        Id.generateId()
                )
        );
    }
}
