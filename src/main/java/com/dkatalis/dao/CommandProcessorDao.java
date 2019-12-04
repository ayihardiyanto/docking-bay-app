package com.dkatalis.dao;

public interface CommandProcessorDao {
    String executeCommand(String[] commandLine);
}
