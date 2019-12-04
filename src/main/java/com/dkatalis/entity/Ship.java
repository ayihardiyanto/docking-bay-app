package com.dkatalis.entity;


public class Ship {
    private String boatRegistrationNumber;

    public Ship(String boatRegistrationNumber) {
        this.boatRegistrationNumber = boatRegistrationNumber;
    }

    public Ship() {
    }

    public String getBoatRegistrationNumber() {
        return boatRegistrationNumber;
    }

    public void setBoatRegistrationNumber(String boatRegistrationNumber) {
        this.boatRegistrationNumber = boatRegistrationNumber;
    }

}
