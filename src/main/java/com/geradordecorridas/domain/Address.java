package com.geradordecorridas.domain;

public class Address {
    private String streetName;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;
    private GeoPoint geoPoint;

    public Address() {
    }

    public Address(String streetName, String number, String complement, String city, String state, String zipCode, GeoPoint geoPoint) {
        this.streetName = streetName;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.geoPoint = geoPoint;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }
}
