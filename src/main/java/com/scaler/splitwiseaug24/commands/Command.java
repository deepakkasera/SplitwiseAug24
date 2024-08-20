package com.scaler.splitwiseaug24.commands;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
