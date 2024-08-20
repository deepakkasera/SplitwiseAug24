package com.scaler.splitwiseaug24.commands;

import java.util.List;

public class RegisterCommand implements Command {

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 4 && words.get(0).equals("Register");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        String username = words.get(1);
        String phoneNumber = words.get(2);
        String passsword = words.get(3);

        //SignUp Method.
    }
}
