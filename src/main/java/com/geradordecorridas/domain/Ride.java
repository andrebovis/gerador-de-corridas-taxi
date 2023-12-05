package com.geradordecorridas.domain;

import java.math.BigDecimal;
import java.util.*;

public class Ride {
    private Id id;
    private Passenger passenger;
    private Driver driver;
    private Address from;
    private Address to;
    private float distance;
    private List<Transaction> transactions;
    private Status status;

    public Ride() {
    }

    public Ride(Id id, Passenger passenger, Driver driver, Address from, Address to, float distance, List<Transaction> transactions, Status status) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.transactions = transactions;
        this.status = status;
    }

    public static Ride createRide(Passenger passenger, Driver driver, Address from, Address to) {
        float distance = calculateDistance();
        Money value = calculateValue(distance);
        Transaction transaction = createTransaction(passenger, driver, value);
        return new Ride(
                Id.generateId(),
                passenger,
                driver,
                from,
                to,
                distance,
                List.of(transaction),
                Status.ACTIVE);
    }

    public void cancelRide() {
        if (this.status.equals(Status.CANCELED))
            throw new RuntimeException("A corrida já está cancelada.");
        Transaction transaction = createReversal(passenger, driver, getTransactions().getFirst().getValue());
        this.transactions = Arrays.asList(getTransactions().getFirst(), transaction);
        this.status = Status.CANCELED;
    }

    private static float calculateDistance() {
        return getRandomFloat();
    }

    private static Money calculateValue(float distance) {
        BigDecimal valuePerKm = BigDecimal.valueOf(1.5f);
        return new Money(BigDecimal.valueOf(distance).multiply(valuePerKm));
    }

    private static Transaction createTransaction(Passenger passenger, Driver driver, Money value) {
        return Transaction.createTransaction(
                passenger.getAccount(),
                driver.getAccount(),
                value
        );
    }

    private static Transaction createReversal(Passenger passenger, Driver driver, Money value) {
        return Transaction.createReversal(
                passenger.getAccount(),
                driver.getAccount(),
                value
        );
    }

    public static float getRandomFloat() {
        Random random = new Random();
        return random.nextFloat(55f) + 5f;
    }

    public Id getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public Address getFrom() {
        return from;
    }

    public Address getTo() {
        return to;
    }

    public float getDistance() {
        return distance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride ride)) return false;
        return Objects.equals(id, ride.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
