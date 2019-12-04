package com.dkatalis.dao;

import com.dkatalis.entity.Ship;

public interface DockingShipDao {
    public String dock(String registrationNumber);
    public String leave (Integer pier);
    public String generateBoatingDock();
    public String reserve(String registrationNumber);
    public String status();
}
