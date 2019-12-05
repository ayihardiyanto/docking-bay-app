package com.dkatalis.dao.impl;

import com.dkatalis.dao.CommandExecutorDao;
import com.dkatalis.dao.FileReaderProcessorDao;

import java.io.BufferedReader;
import java.io.IOException;

/*
* FileReaderProcessorDaoImpl is a class that implements FileReaderProcessorDao
* this class will be used once file (.txt) is inserted as the program is running
* using file (.txt) option
* */

public class FileReaderProcessorDaoImpl implements FileReaderProcessorDao {
    private boolean executed = false;
    private CommandExecutorDao commandProcessor = new CommandExecutorDaoImpl();

    /**
     * executed (boolean) will valued false if commandLine is not containing specified commands
     */

    @Override
    public boolean readCommand(BufferedReader bufferedReader) throws IOException {
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
