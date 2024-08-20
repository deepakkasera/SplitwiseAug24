package com.scaler.splitwiseaug24;

import com.scaler.splitwiseaug24.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAug24Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandExecutor commandExecutor = new CommandExecutor();

        while (true) {
            String input = scanner.next();
            commandExecutor.executeCommand(input);
        }
    }

}
