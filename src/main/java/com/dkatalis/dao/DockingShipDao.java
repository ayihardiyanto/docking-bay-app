package com.dkatalis.dao;

import com.dkatalis.entity.Ship;

public interface DockingShipDao {
    public String dock(Ship ship);
    public String leave (Ship ship);
    public String generateBoatingDock();
    public String reserve(Ship ship);
    public String status();
}
