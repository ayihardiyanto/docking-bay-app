package com.dkatalis.dao.impl;

import com.dkatalis.dao.CommandInputProcessorDao;
import org.junit.Assert;
import org.junit.Test;
import java.io.*;


public class CommandInputProcessorDaoImplTest {


    @Test
    public void inputCommand_shouldReturn_true_when_input_canBeRead() throws IOException {
        String command = "create_boating_dock 6";
        InputStream commandToInputStream = new ByteArrayInputStream(command.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(commandToInputStream));
        CommandInputProcessorDao inputReader = new CommandInputProcessorDaoImpl();
        boolean actual = inputReader.inputCommand(reader);

        Assert.assertEquals(true, actual);
    }

    @Test
    public void inputCommand_shouldReturn_false_when_file_cannotBeRead() throws IOException {
        String command = "Nothing's To Do";
        InputStream commandToInputStream = new ByteArrayInputStream(command.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(commandToInputStream));
        CommandInputProcessorDao inputReader = new CommandInputProcessorDaoImpl();
        boolean actual = inputReader.inputCommand(reader);

        Assert.assertEquals(false, actual);
    }
}