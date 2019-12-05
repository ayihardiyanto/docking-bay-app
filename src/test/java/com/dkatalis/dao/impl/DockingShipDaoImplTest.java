package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.constant.TextFormat;
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
        String expectedResult = String.format(Message.INVALID_NUMBER_OF_PIERS, givenNumberOfPier);
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


    @Test
    public void leave_shouldReturn_leaveSuccesMessage_when_givenNumberOfPier_is_one_and_one_boat_with_specifiedRegistrationNumber() {
        Integer givenNumberOfPier = 1;
        String regNumber = "AAAA";
        String expected = String.format(Message.LEAVE_SUCCESS, givenNumberOfPier);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.dock(regNumber);
        String actual = dockingShipDao.leave(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leave_shouldReturn_leaveFailedMessage_when_givenNumberOfPier_is_one_and_no_boat_with_specifiedRegistrationNumber() {
        Integer givenNumberOfPier = 1;
        String regNumber = "AAAA";
        String expected = String.format(Message.LEAVE_FAILED, 1);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        String actual = dockingShipDao.leave(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leave_shouldReturn_stillInReserveMessage_when_givenNumberOfPier_is_one_and_reserved_boat_with_specifiedRegistrationNumber_not_docked_yet() {
        Integer givenNumberOfPier = 1;
        String regNumber = "AAAA";
        String expected = String.format(Message.STILL_IN_RESERVE, regNumber);
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(givenNumberOfPier);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.reserve(regNumber);
        String actual = dockingShipDao.leave(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void status_shouldReturn_currentStatus_of_each_activePiers_when_there_is_a_boat_with_reserved_status() {
        StringBuilder builder = new StringBuilder();
        builder.append(TextFormat.STATUS_HEADER);
        String regNumber = "AABB";
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(1);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.reserve(regNumber);
        String expected = builder.append(String.format(TextFormat.STATUS_FORMAT, 1, regNumber, Message.RESERVED_STATUS)).toString();
        String actual = dockingShipDao.status();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void status_shouldReturn_currentStatus_of_each_activePiers_when_there_are_boats_with_docked_and_reserved_status() {
        StringBuilder builder = new StringBuilder();
        builder.append(TextFormat.STATUS_HEADER);
        String regNumber = "AABB";
        DockingShipDao dockingShipDao = new DockingShipDaoImpl(6);
        dockingShipDao.generateBoatingDock();
        dockingShipDao.reserve(regNumber);
        dockingShipDao.dock("ABCD");
        dockingShipDao.dock("AADC");
        dockingShipDao.reserve("AAAA");
        builder.append(String.format(TextFormat.STATUS_FORMAT, 1, regNumber, Message.RESERVED_STATUS));
        builder.append(String.format(TextFormat.STATUS_FORMAT, 2, "ABCD", Message.DOCKED_STATUS));
        builder.append(String.format(TextFormat.STATUS_FORMAT, 3, "AADC", Message.DOCKED_STATUS));
        builder.append(String.format(TextFormat.STATUS_FORMAT, 4, "AAAA", Message.RESERVED_STATUS));
        String expected = builder.toString();

        String actual = dockingShipDao.status();

        Assert.assertEquals(expected, actual);


    }
}