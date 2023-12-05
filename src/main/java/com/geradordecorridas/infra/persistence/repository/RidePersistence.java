package com.geradordecorridas.infra.persistence.repository;

import com.geradordecorridas.domain.Address;
import com.geradordecorridas.domain.Driver;
import com.geradordecorridas.domain.Passenger;
import com.geradordecorridas.domain.Ride;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RidePersistence {

    public Set<Driver> diverDB = new HashSet<>();
    public Set<Passenger> passengerDB = new HashSet<>();
    public Set<Ride> rideDB = new HashSet<>();

    public RidePersistence() {
        this.diverDB.add(Driver.createNewDriver());
    }

    public Ride createRide(Passenger passenger, Driver driver, Address from, Address to) {
        //TODO: Validar se passageiro já possui corrida ativa.
        Ride ride = Ride.createRide(passenger, driver, from, to);
        rideDB.add(ride);
        return ride;
    }

    public Ride cancelRide(Ride ride) {
        ride.cancelRide();
        return ride;
    }

    public Ride findRideById(String id) {
        Ride ride = null;
        for (Ride r : rideDB) {
            if (r.getId().getId().toString().equals(id)) {
                ride = r;
            }
        }
        return ride;
    }

    public Driver findDriver() {
        return this.diverDB.iterator().next();
    }

    public Passenger findPassengerByDocument(String document) {
        Passenger passenger = null;
        for (Passenger p : passengerDB) {
            if (p.getDocument().equals(document)){
                passenger = p;
            }
        }

        return passenger;
    }
}
