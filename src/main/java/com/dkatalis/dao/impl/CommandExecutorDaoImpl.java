package com.dkatalis.dao.impl;

import com.dkatalis.dao.CommandExecutorDao;
import com.dkatalis.dao.DockingShipDao;

import static com.dkatalis.constant.Command.*;

public class CommandExecutorDaoImpl implements CommandExecutorDao {
    private DockingShipDao dockingShipDao;
    private final Integer PARAM_ONE = 1;
    private final Integer COMMAND = 0;

    @Override
    public String executeCommand(String[] commandLine) {
        String command = commandLine[COMMAND].toLowerCase();
        switch (command) {
            case CREATE_BOATING_DOCK:
                return executeCreateBoatingDock(commandLine[PARAM_ONE]);
            case RESERVE:
                return dockingShipDao.reserve(commandLine[PARAM_ONE]);
            case DOCK:
                return dockingShipDao.dock(commandLine[PARAM_ONE]);
            case LEAVE:
                Integer pier = Integer.valueOf(commandLine[1]);
                return dockingShipDao.leave(pier);
            case STATUS:
                return dockingShipDao.status();
            case EXIT:
                System.exit(0);
            default:
                return null;
        }
    }

    private String executeCreateBoatingDock(String s) {
        Integer numbOfPiers = Integer.valueOf(s);
        dockingShipDao = new DockingShipDaoImpl(numbOfPiers);
        return dockingShipDao.generateBoatingDock();
    }
}
