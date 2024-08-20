package com.scaler.splitwiseaug24.services;

import com.scaler.splitwiseaug24.models.Expense;
import com.scaler.splitwiseaug24.models.ExpenseUser;
import com.scaler.splitwiseaug24.models.User;
import com.scaler.splitwiseaug24.repositories.ExpenseUserRepository;
import com.scaler.splitwiseaug24.repositories.UserRepository;
import com.scaler.splitwiseaug24.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) {
        /*
        1. Get the user with the given userId.
        2. Get all the expenses in which current user is a part of.
        3. Iterate through all the expenses and find out the users who have
        paid extra and who have paid lesser.
        4. Implement the settle up algorithm using MIN & MAX heap.
         */

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User with id: " + userId + " doesn't exist.");
        }

        User user = optionalUser.get();

        //Fetch all the ExpenseUser for the given user.
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        //Get the expenses from ExpenseUser objects.
        Set<Expense> expenses = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> expensesToSettle = settleUpStrategy.settleUp(expenses.stream().toList()); // Dummy Expenses.

        List<Expense> expensesToReturn = new ArrayList<>();

        for (Expense expense : expensesToSettle) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user)) {
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }

        return expensesToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId) {
        return null;
    }
}


/*
 *
 * E1
 * U1
 *
 *
 * E1U1 -> paid 1000Rs
 * E1U1 -> had to pay 200Rs
 *
 */
