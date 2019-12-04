package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.dao.DockingShipDao;
import com.dkatalis.entity.Ship;

import java.util.HashMap;
import java.util.Map;

public class DockingShipDaoImpl implements DockingShipDao {
    private Map<Integer, String> dockingPiers = new HashMap<Integer, String>();
    private Integer numberOfPier;

    public DockingShipDaoImpl(Integer numberOfPier) {
        this.numberOfPier = numberOfPier;
    }

    public String generateBoatingDock() {
        if (numberOfPier == 0) return String.format(Message.INVALID_NUMBER_OF_TIERS, numberOfPier);
        for (int pier = 1; pier <= numberOfPier; pier++){
            dockingPiers.put(pier, null);
        }
        return String.format(Message.PIER_CREATED, numberOfPier);
    }

    public String reserve(Ship ship) {
        return null;
    }

    public String dock(Ship ship) {
        return null;
    }

    public String leave(Ship ship) {
        return null;
    }

    public String status() {
        return null;
    }
}
