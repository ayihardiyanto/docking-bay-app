package com.dkatalis.entity;

public class Pier {
    private Ship ship;
    private String status;

    public Pier(Ship ship, String status) {
        this.ship = ship;
        this.status = status;
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
