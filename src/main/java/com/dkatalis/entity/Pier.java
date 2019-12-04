package com.dkatalis.entity;

public class Pier {
    private Ship ship;

    public Pier(Ship ship) {
        this.ship = ship;
    }

    public Pier() {
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
