package com.dkatalis.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(boatRegistrationNumber, ship.boatRegistrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boatRegistrationNumber);
    }
}
