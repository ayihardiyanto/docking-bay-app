package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.constant.TextFormat;
import com.dkatalis.dao.DockingShipDao;
import com.dkatalis.entity.Pier;
import com.dkatalis.entity.Ship;

import java.util.HashMap;
import java.util.Map;

/*
 * DockingShopDaoImpl is an implemented class from DockingShipDao interface
 * this class will manage dock activity functions
 * such as generating new piers, reserve pier, dock, and leave
 * also, current status will be displayed for which piers are being active in a moment
 * */

public class DockingShipDaoImpl implements DockingShipDao {
    private Map<Integer, Pier> piers = new HashMap<Integer, Pier>();
    private Map<Integer, Pier> reservedPiers = new HashMap<>();
    private Integer numberOfPier;

    /**
     * creating new piers can use DockingShipDaoImp constructor
     */
    public DockingShipDaoImpl(Integer numberOfPier) {
        this.numberOfPier = numberOfPier;
    }

    /**
     * empty DockingShipDaoImpl constructor is used to instantiate
     * DockingShipDaoImpl class without setting numberOfPier in the front
     */

    public DockingShipDaoImpl(){
    }

    /**
     * once DockingShipDaoImp constructor is called, it will generate piers but not the message
     * there fore generateBoatingDock will give some outputs regarding to the generating process
     */

    public String generateBoatingDock() {
        if (numberOfPier == 0) return String.format(Message.INVALID_NUMBER_OF_PIERS, numberOfPier);
        for (int pier = 1; pier <= numberOfPier; pier++) {
            piers.put(pier, null);
        }
        return String.format(Message.PIER_CREATED, numberOfPier);
    }

    /**
     * Boat will be able to do things, after piers are generated
     * for reserving pier, there will be registrationNumber of the boat needed
     */

    public String reserve(String registrationNumber) {
        if (isReserved(registrationNumber)) return Message.EXISTING_RESERVATION;
        for (Map.Entry<Integer, Pier> pier : piers.entrySet()) {
            if (pier.getValue() == null) {
                reservedPiers.put(pier.getKey(), new Pier(new Ship(registrationNumber), Message.RESERVED_STATUS)); //new
                piers.put(pier.getKey(), new Pier(new Ship(registrationNumber), Message.RESERVED_STATUS));
                return String.format(Message.RESERVE_SUCCESS, pier.getKey());
            }
        }
        return Message.FULL_PIER_MESSAGE;
    }


    /**
     * Boat can dock immediately without reserving pier
     * if pier is empty (without any pier obj) from boat/reservation
     */

    public String dock(String registrationNumber) {
        if (piers.isEmpty()) return Message.NO_BOATING_DOCK;
        for (Map.Entry<Integer, Pier> pier : piers.entrySet()) {
            if (isReserved(registrationNumber))
                return reserveToDock(registrationNumber);
            if (pier.getValue() == null) {
                piers.put(pier.getKey(), new Pier(new Ship(registrationNumber), Message.DOCKED_STATUS));
                return String.format(Message.DOCK_SUCCESS, pier.getKey());
            }
        }
        return Message.FULL_PIER_MESSAGE;
    }

    /**
     * reserveToDock used to change status from reserved to dock
     * by checking reservation list/ reservedPiers (Map)
     * the method will return success message only
     * due to reservation check on isReserve method
     */

    private String reserveToDock(String registrationNumber) { //new
        Integer pierNumb = 0;
        for (Map.Entry<Integer, Pier> reservedPier : reservedPiers.entrySet()) {
            if (reservedPier.getValue() != null)
                pierNumb = reservedPier.getKey();
                if (reservedPier.getValue().getShip().getBoatRegistrationNumber().equals(registrationNumber)) {
                    piers.put(reservedPier.getKey(), new Pier(new Ship(registrationNumber), Message.DOCKED_STATUS));
                    break;
                }
        }
        return String.format(Message.DOCK_SUCCESS, pierNumb);
    }

    /**
     * isReserved is  used to determine registrationNumber
     * whether the boat already made reservation or not
     * by iterating reservedPiers (Map)
     */

    private boolean isReserved(String registrationNumber) {
        for (Map.Entry<Integer, Pier> reservedPier : piers.entrySet()) {
            if (reservedPier.getValue() != null)
                if (reservedPier.getValue().getShip().getBoatRegistrationNumber().equals(registrationNumber)) {
                    return true;
                }
        }
        return false;
    }

    /**
     * leave will be able to used once at least, a boat is docked
     * when this function used to a reserved pier, it will affect nothing
     * since the boat is not exist, but the pier is reserved
     */

    public String leave(Integer pierNumber) {
        if (piers.isEmpty()) return Message.NO_BOATING_DOCK;
        for (Map.Entry<Integer, Pier> pier : piers.entrySet()) {
            if (pier.getValue() != null) {
                if (pier.getValue().getStatus().equals(Message.RESERVED_STATUS))
                    return String.format(Message.STILL_IN_RESERVE, pier.getValue().getShip().getBoatRegistrationNumber());
                if (pier.getKey().equals(pierNumber)) {
                    piers.put(pier.getKey(), null);
                    return String.format(Message.LEAVE_SUCCESS, pier.getKey());
                }
            }
        }
        return String.format(Message.LEAVE_FAILED, pierNumber);
    }

    /**
     * status function will provide information of active piers (being used/ reserved)
     */

    public String status() {
        StringBuilder statusBuilder = new StringBuilder();
        statusBuilder.append(TextFormat.STATUS_HEADER);
        if (piers.isEmpty()) return Message.NO_BOATING_DOCK;
        for (Map.Entry<Integer, Pier> pier : piers.entrySet()) {
            if (pier.getValue() != null)
               statusBuilder.append(String.format(TextFormat.STATUS_FORMAT, pier.getKey(), pier.getValue().getShip().getBoatRegistrationNumber(), pier.getValue().getStatus())).toString();
        }
        return  statusBuilder.toString();
    }


}
