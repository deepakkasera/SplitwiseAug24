package com.scaler.splitwiseaug24.commands;

import com.scaler.splitwiseaug24.controllers.SettleUpController;
import com.scaler.splitwiseaug24.dtos.SettleUpGroupRequestDto;
import com.scaler.splitwiseaug24.dtos.SettleUpUserRequestDto;
import com.scaler.splitwiseaug24.dtos.SettleUpUserResponseDto;

import java.util.List;

public class SettleUpUserCommand implements Command {
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equals(CommandKeywords.SettleUpCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(Long.valueOf(words.get(0)));

        SettleUpController settleUpController = new SettleUpController();
        SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);
    }
}
