package com.midhun.hawkssolutions.transport.Response;

import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;

import java.util.List;

public class ExpenseDetailsApiModel {
    List<ExpensesDetails> expenses;

    public ExpenseDetailsApiModel(List<ExpensesDetails> expenses) {
        this.expenses = expenses;
    }

    public List<ExpensesDetails> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpensesDetails> expenses) {
        this.expenses = expenses;
    }
}
