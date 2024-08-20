package com.scaler.splitwiseaug24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany
    private List<ExpenseUser> expenseUsers;
}

/*

   1            1
Expense ----- Group => M:1
   M            1

   1             M
Expense ----- ExpenseUser => 1:M
  1               1

 */
