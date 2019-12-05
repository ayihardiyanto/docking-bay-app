package com.dkatalis.dao.impl;

import com.dkatalis.dao.CommandInputProcessorDao;
import com.dkatalis.dao.CommandExecutorDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * CommandInputProcessorDaoImpl is a class that implements CommandInputProcessorDao
 * this class will be used once user choose to use command input
 * */
public class CommandInputProcessorDaoImpl implements CommandInputProcessorDao {
    /**
     * executed (boolean) will valued false if commandLine is not containing specified commands
     */
    private boolean executed = false;
    private CommandExecutorDao commandProcessor = new CommandExecutorDaoImpl();

    @Override
    public boolean inputCommand(String commandLine){
        String executedResult;
        String[] lineRead = commandLine.trim().split("\\s+");
        executedResult = commandProcessor.executeCommand(lineRead);

        if (executedResult != null) {
            executed = true;
            System.out.println(executedResult);
        }
        return executed;
    }
}
