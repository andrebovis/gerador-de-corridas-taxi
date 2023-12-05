package com.geradordecorridas.infra.api.v1.controllers;

import com.geradordecorridas.domain.Address;

public class RideRequestDTO {
    private PassengerDTO passenger;
    private Address from;
    private Address to;

    public RideRequestDTO(PassengerDTO passenger, Address from, Address to) {
        this.passenger = passenger;
        this.from = from;
        this.to = to;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public Address getTo() {
        return to;
    }

    public void setTo(Address to) {
        this.to = to;
    }
}
