package com.scaler.splitwiseaug24.strategies;

import com.scaler.splitwiseaug24.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
