package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.dao.DockingShipDao;
import com.dkatalis.entity.Pier;
import com.dkatalis.entity.Ship;

import java.util.HashMap;
import java.util.Map;

public class DockingShipDaoImpl implements DockingShipDao {
    private Map<Integer, Pier> piers = new HashMap<Integer, Pier>();
    private Integer numberOfPier;

    public DockingShipDaoImpl(Integer numberOfPier) {
        this.numberOfPier = numberOfPier;
    }

    public String generateBoatingDock() {
        if (numberOfPier == 0) return String.format(Message.INVALID_NUMBER_OF_TIERS, numberOfPier);
        for (int pier = 1; pier <= numberOfPier; pier++){
            piers.put(pier, null);
        }
        return String.format(Message.PIER_CREATED, numberOfPier);
    }

    public String reserve(Ship ship) {

        return null;
    }

    public String dock(String registrationNumber) {
        for (Map.Entry<Integer, Pier> pier : piers.entrySet()){
            if (pier.getValue() == null){
                piers.put(pier.getKey(), new Pier(new Ship(registrationNumber)));
                return String.format(Message.DOCK_SUCCESS, pier.getKey());
            }
        }
        return Message.DOCK_FAILED;
    }

    public String leave(String registrationNumber) {
        return null;
    }

    public String status() {
        return null;
    }


}
