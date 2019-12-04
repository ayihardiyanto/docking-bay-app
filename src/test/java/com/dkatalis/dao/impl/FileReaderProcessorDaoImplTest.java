package com.dkatalis.dao.impl;

import com.dkatalis.constant.Variable;
import com.dkatalis.dao.FileReaderProcessorDao;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileReaderProcessorDaoImplTest {

    @Test
    public void readCommand_shouldReturn_true_when_file_canBeRead() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(Variable.URL));
        FileReaderProcessorDao fileReader = new FileReaderProcessorDaoImpl();
        boolean actual = fileReader.readCommand(reader);

        Assert.assertEquals(true, actual);
    }

    @Test
    public void readCommand_shouldReturn_false_when_file_cannotBeRead() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(Variable.DECOY_URL));
        FileReaderProcessorDao fileReader = new FileReaderProcessorDaoImpl();
        boolean actual = fileReader.readCommand(reader);

        Assert.assertEquals(false, actual);
    }
}