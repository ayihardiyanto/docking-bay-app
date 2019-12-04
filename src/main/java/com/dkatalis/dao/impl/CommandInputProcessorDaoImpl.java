package com.dkatalis.dao.impl;

import com.dkatalis.dao.CommandInputProcessorDao;
import com.dkatalis.dao.CommandExecutorDao;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandInputProcessorDaoImpl implements CommandInputProcessorDao {

    private boolean executed = false;
    private CommandExecutorDao commandProcessor = new CommandExecutorDaoImpl();

    @Override
    public boolean inputCommand(BufferedReader bufferedReader) throws IOException {
        String line;
        String executedResult;
        while((line = bufferedReader.readLine()) != null){
            String[] lineRead = line.trim().split("\\s+");
            executedResult = commandProcessor.executeCommand(lineRead);

            if (executedResult != null) {
                executed = true;
                System.out.println(executedResult);
            }
        }
        return executed;
    }
}
