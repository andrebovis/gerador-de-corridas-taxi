package com.geradordecorridas.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Id id;
    private List<Transaction> transactions;
    private Money balance;

    public Account() {
    }

    public Account(Id id) {
        this.id = id;
        this.transactions = new ArrayList<>();
        this.balance = new Money(BigDecimal.ZERO);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void add(Money value) {
        this.balance = new Money(this.balance.getValue().add(value.getValue()));
    }

    public void subtract(Money value) {
        this.balance = new Money(this.balance.getValue().subtract(value.getValue()));
    }

    public Money getBalance() {
        return balance;
    }

    public Id getId() {
        return id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
