package com.dkatalis.dao;

import java.io.BufferedReader;
import java.io.IOException;

public interface FileReaderProcessorDao {
    boolean readCommand(BufferedReader bufferedReader) throws IOException;
}
