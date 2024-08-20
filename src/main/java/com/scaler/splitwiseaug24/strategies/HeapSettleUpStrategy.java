package com.scaler.splitwiseaug24.strategies;

import com.scaler.splitwiseaug24.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return null;
    }
}
