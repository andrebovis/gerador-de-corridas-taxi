package com.geradordecorridas.infra.api.v1.controllers;

import com.geradordecorridas.domain.Driver;
import com.geradordecorridas.domain.Passenger;
import com.geradordecorridas.domain.Ride;
import com.geradordecorridas.infra.persistence.repository.RidePersistence;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@RestController
@RequestMapping(value = "ride")
public class RideController {

    private final RidePersistence ridePersistence;

    public RideController(RidePersistence ridePersistence) {
        this.ridePersistence = ridePersistence;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Ride> create(@RequestBody RideRequestDTO rideRequestDTO) {
        Passenger passenger = ridePersistence
                .findPassengerByDocument(rideRequestDTO.getPassenger().getDocument());
        if (passenger == null) {
            passenger = Passenger.createPassenger(
                    rideRequestDTO.getPassenger().getName(),
                    rideRequestDTO.getPassenger().getUsername(),
                    rideRequestDTO.getPassenger().getDocument()
            );
            ridePersistence.passengerDB.add(passenger);
        }

        Driver driver = ridePersistence.findDriver();

        Ride ride = ridePersistence
                .createRide(passenger, driver, rideRequestDTO.getFrom(), rideRequestDTO.getTo());

        return ResponseEntity.ok(ride);
    }

    @DeleteMapping
    public ResponseEntity<Ride> cancel(@RequestParam(value = "id") String id) {
        Ride ride = ridePersistence.findRideById(id);
        if (ride == null)
            throw new RuntimeException("A corrida não foi encontrada.");
        ridePersistence.cancelRide(ride);

        return ResponseEntity.ok(ride);
    }

}
