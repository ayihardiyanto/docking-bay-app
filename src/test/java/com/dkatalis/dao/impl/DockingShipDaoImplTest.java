package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.dao.DockingShipDao;
import org.junit.Assert;
import org.junit.Test;

public class DockingShipDaoImplTest {

    @Test
    public void generateBoatingDock_shouldReturn_pierCreatedSuccessMessage_when_givenNumberOfPier_is_six() {
        Integer givenNumberOfPier = 6;
        String expectedResult = String.format(Message.PIER_CREATED, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        String actualResult = dockingShipDao.generateBoatingDock();

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void generateBoatingDock_shouldReturn_pierCreatedFailedMessage_when_givenNumberOfPier_is_zero() {
        Integer givenNumberOfPier = 0;
        String expectedResult = String.format(Message.INVALID_NUMBER_OF_TIERS, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        String actualResult = dockingShipDao.generateBoatingDock();

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void dock_shouldReturn_dockSuccessMessage_when_givenNumberOfPier_is_one_with_one_boat() {
        Integer givenNumberOfPier = 1;
        String expected = String.format(Message.DOCK_SUCCESS, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        String actual = dockingShipDao.dock("ABCD");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dock_shouldReturn_dockSuccessMessage_with_givenNumberOfPier_is_one_when_reserve_previously() {
        Integer givenNumberOfPier = 1;
        String expected = String.format(Message.DOCK_SUCCESS, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.reserve("ABCD");
        String actual = dockingShipDao.dock("ABCD");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dock_shouldReturn_fullPierMessage_when_givenNumberOfPier_is_one_with_two_boats() {
        Integer givenNumberOfPier = 1;
        String expected = Message.FULL_PIER_MESSAGE;
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.dock("ABCD");
        String actual = dockingShipDao.dock("DEFG");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reserve_shouldReturn_reserveSuccessMessage_when_givenNumberOfPier_is_one_with_boatToReserve_is_one() {
        Integer givenNumberOfPier = 1;
        String expected = String.format(Message.RESERVE_SUCCESS, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        String actual = dockingShipDao.reserve("ABCD");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reserve_shouldReturn_fullPierMessage_when_givenNumberOfPier_is_one_with_two_boatsToBeReserved() {
        Integer givenNumberOfPier = 1;
        String expected = String.format(Message.FULL_PIER_MESSAGE);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.reserve("ABCD");
        String actual = dockingShipDao.reserve("DEFG");

        Assert.assertEquals(expected, actual);

    }
}