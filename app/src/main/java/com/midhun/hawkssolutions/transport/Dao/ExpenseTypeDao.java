package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.ExpenseType;

import java.util.List;

@Dao
public interface ExpenseTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExoenseType(List<ExpenseType> expenseTypeList);

    @Query("SELECT * FROM expensetype")
    LiveData<List<ExpenseType>> getExpenseTypeDao();

    @Query("DELETE FROM expensetype")
    void deleteALlExpenseType();

}
