package com.geradordecorridas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Transaction {
    private Id id;
    @JsonIgnore
    private Account passengerAccount;
    @JsonIgnore
    private Account driverAccount;
    private Money value;
    private boolean reversal;

    public Transaction() {
    }

    private Transaction(Id id, Account passengerAccount, Account driverAccount, Money value, boolean reversal) {
        this.id = id;
        this.passengerAccount = passengerAccount;
        this.driverAccount = driverAccount;
        this.value = value;
        this.reversal = reversal;
    }

    public static Transaction createTransaction(Account passengerAccount, Account driverAccount, Money value) {
        Transaction transaction = new Transaction(
                Id.generateId(),
                passengerAccount,
                driverAccount,
                value,
                false);
        passengerAccount.addTransaction(transaction);
        passengerAccount.subtract(value);
        driverAccount.addTransaction(transaction);
        driverAccount.add(value);

        return transaction;
    }

    public static Transaction createReversal(Account passengerAccount, Account driverAccount, Money value) {
        Transaction transaction = new Transaction(
                Id.generateId(),
                passengerAccount,
                driverAccount,
                value,
                true);
        passengerAccount.addTransaction(transaction);
        passengerAccount.add(value);
        driverAccount.addTransaction(transaction);
        driverAccount.subtract(value);

        return transaction;
    }

    public Id getId() {
        return id;
    }

    public Account getPassengerAccount() {
        return passengerAccount;
    }

    public Account getDriverAccount() {
        return driverAccount;
    }

    public Money getValue() {
        return value;
    }
    public boolean getReversal() {
        return reversal;
    }
}
