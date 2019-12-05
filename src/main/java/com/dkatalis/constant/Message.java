package com.dkatalis.constant;

public class Message {
    public static final String INVALID_NUMBER_OF_PIERS = "You can't put %s as your number of pier\n";
    public static final String PIER_CREATED = "Created a boating dock with %d piers\n";
    public static final String DOCK_SUCCESS = "Allocated pier number : %d \n";
    public static final String RESERVE_SUCCESS = "Reserved pier number : %d\n";
    public static final String FULL_PIER_MESSAGE = "Sorry, boating dock is full\n";
    public static final String DOCKED_STATUS = "DOCKED";
    public static final String RESERVED_STATUS = "RESERVED";
    public static final String STILL_IN_RESERVE = "dock-app : the pier is reserved by %s, but it's not docked yet\n";
    public static final String LEAVE_SUCCESS = "Pier number %d is free\n";
    public static final String LEAVE_FAILED = "dock-app : currently no boat in pier %d\n";
    public static final String PROGRAM_TERMINATED = "Program Successfully Closed";
    public static final String COMMAND_NOT_FOUND = "dock-app : command not found\n";
    public static final String NO_BOATING_DOCK = "dock-app : currently no piers are built\n";
    public static final String UNDEFINED = "dock-app : can't specify %s command parameter\n";
    public static final String ILLEGAL_NUMBER_INPUT = "dock-app : leave command should use pier number instead of alphabetical character\n";
    public static final String EXISTING_RESERVATION = "dock-app : there is already a reservation made with this registration number";
}
