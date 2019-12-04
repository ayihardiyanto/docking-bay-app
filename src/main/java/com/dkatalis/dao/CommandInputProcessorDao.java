package com.dkatalis.dao;

import java.io.BufferedReader;
import java.io.IOException;

public interface CommandInputProcessorDao {
    boolean inputCommand(BufferedReader bufferedReader) throws IOException;
}
