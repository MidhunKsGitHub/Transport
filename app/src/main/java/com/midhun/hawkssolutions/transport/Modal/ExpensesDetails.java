package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "ExpenseDetails" , indices = @Index(value = {"id"},unique = true))
public class ExpensesDetails {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String id;
    private String trip_id;
    private String expense;
    private String expense_type_id;
    private String quantity;
    private String note;
    private String expense_date;
    private String amount;
    private String trip;

    public ExpensesDetails(String id, String trip_id, String expense, String expense_type_id, String quantity, String note, String expense_date, String amount,String trip) {
        this.id = id;
        this.trip_id = trip_id;
        this.expense = expense;
        this.expense_type_id = expense_type_id;
        this.quantity = quantity;
        this.note = note;
        this.expense_date = expense_date;
        this.amount = amount;
        this.trip=trip;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getExpense_type_id() {
        return expense_type_id;
    }

    public void setExpense_type_id(String expense_type_id) {
        this.expense_type_id = expense_type_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }
}
