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
}