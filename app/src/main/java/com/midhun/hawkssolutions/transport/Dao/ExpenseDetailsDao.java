package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.ExpenseType;
import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;

import java.util.List;

@Dao
public interface ExpenseDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExpenseDetails(List<ExpensesDetails> expensesDetailsList);

    @Query("SELECT * FROM expensedetails")
    LiveData<List<ExpensesDetails>> getExpenseDetailsDao();

    @Query("DELETE FROM expensedetails")
    void deleteExpenseDetails();

}
