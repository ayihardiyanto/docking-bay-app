package com.dkatalis.dao.impl;

import com.dkatalis.constant.TextFormat;
import com.dkatalis.dao.CommandProcessorDao;
import com.dkatalis.dao.FileReaderProcessorDao;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderProcessorDaoImpl implements FileReaderProcessorDao {
    private boolean executed = false;
    private CommandProcessorDao commandProcessor = new CommandProcessorDaoImpl();

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
