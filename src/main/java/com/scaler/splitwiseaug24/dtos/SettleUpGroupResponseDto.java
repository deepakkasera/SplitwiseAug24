package com.scaler.splitwiseaug24.dtos;

import com.scaler.splitwiseaug24.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses; // DUMMY Expenses == Transactions.
}
