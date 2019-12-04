package com.dkatalis.dao;

import com.dkatalis.entity.Ship;

public interface DockingShipDao {
    public String dock(String registrationNumber);
    public String leave (String registrationNumber);
    public String generateBoatingDock();
    public String reserve(Ship ship);
    public String status();
}
