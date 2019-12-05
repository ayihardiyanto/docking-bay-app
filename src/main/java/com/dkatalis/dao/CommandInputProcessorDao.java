package com.dkatalis.dao;

import java.io.BufferedReader;
import java.io.IOException;

public interface CommandInputProcessorDao {
    boolean inputCommand(String commandInput) throws IOException;
}
