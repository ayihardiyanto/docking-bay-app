package com.dkatalis.entity;

import com.dkatalis.constant.Message;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PierTest {
    @Test
    public void setPier_shouldReturn_givenShipRegisteredNumber(){
        Pier pier = new Pier();
        Ship ship = new Ship();
        ship.setBoatRegistrationNumber("AA");
        pier.setShip(ship);
        String expected = "AA";
        String actual= pier.getShip().getBoatRegistrationNumber();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setPier_shouldReturn_givenShipStatus(){
        Pier pier = new Pier();
        pier.setStatus(Message.DOCKED_STATUS);
        String expected = Message.DOCKED_STATUS;
        String actual= pier.getStatus();

        Assert.assertEquals(expected, actual);

    }
}