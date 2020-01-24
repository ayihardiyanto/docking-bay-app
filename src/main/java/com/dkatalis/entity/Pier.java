package com.dkatalis.entity;

public class Pier {
    private Ship ship;
    private String status;

    public String getStatus() {
        return status;
    }

    public Pier() {
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pier(Ship ship, String status) {
        this.ship = ship;
        this.status = status;
    }

    public Pier(Ship ship) {
        this.ship = ship;
    }


    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

}
