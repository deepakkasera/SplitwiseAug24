package com.scaler.splitwiseaug24.commands;

import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void executeCommand(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
