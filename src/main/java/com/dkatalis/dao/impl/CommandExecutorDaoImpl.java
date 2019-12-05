package com.dkatalis.dao.impl;

import com.dkatalis.constant.Message;
import com.dkatalis.dao.CommandExecutorDao;
import com.dkatalis.dao.DockingShipDao;

import static com.dkatalis.constant.Command.*;

/*
 * CommandExecutorDaoImpl is an implementation of CommandExecutorDao
 * this class provide function that will be used to execute command
 * whether using file (.txt) or inputs
 * */

public class CommandExecutorDaoImpl implements CommandExecutorDao {
    private DockingShipDao dockingShipDao = new DockingShipDaoImpl();
    private final Integer PARAM_ONE = 1;
    private final Integer COMMAND = 0;

    /**
     * executeCommand will filter the incoming commands, that is collected by the Strign[] commandLine
     * the case that match with commindLine will be executed
     */

    @Override
    public String executeCommand(String[] commandLine) {
        try {
            String command = commandLine[COMMAND].toLowerCase();
            switch (command) {
                case CREATE_BOATING_DOCK:
                    return executeCreateBoatingDock(commandLine[PARAM_ONE]);
                case RESERVE:
                    return dockingShipDao.reserve(commandLine[PARAM_ONE]);
                case DOCK:
                    return dockingShipDao.dock(commandLine[PARAM_ONE]);
                case LEAVE:
                    try{
                        Integer pier = Integer.valueOf(commandLine[1]);
                        return dockingShipDao.leave(pier);
                    } catch (NumberFormatException e){
                        return Message.ILLEGAL_NUMBER_INPUT;
                    }
                case STATUS:
                    return dockingShipDao.status();
                case EXIT:
                    System.out.println(Message.PROGRAM_TERMINATED);
                    System.exit(0);
                default:
                    System.out.println(Message.COMMAND_NOT_FOUND);
                    return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return String.format(Message.UNDEFINED, commandLine[COMMAND]);
        }
    }

    /**
     * this method is an extraction from the case above, it will provides some detailed process
     * of how create boating dock happen
     */

    private String executeCreateBoatingDock(String s) {
        Integer numbOfPiers = Integer.valueOf(s);
        dockingShipDao = new DockingShipDaoImpl(numbOfPiers);
        return dockingShipDao.generateBoatingDock();
    }
}
