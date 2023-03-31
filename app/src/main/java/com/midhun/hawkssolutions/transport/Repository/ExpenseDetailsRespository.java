package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import com.midhun.hawkssolutions.transport.Dao.ExpenseDetailsDao;
import com.midhun.hawkssolutions.transport.Dao.ExpenseTypeDao;
import com.midhun.hawkssolutions.transport.Database.ExpenseDetailsDatabase;
import com.midhun.hawkssolutions.transport.Database.ExpenseTypeDatabase;
import com.midhun.hawkssolutions.transport.Modal.ExpenseType;
import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;

import java.util.List;

public class ExpenseDetailsRespository {
    private ExpenseDetailsDatabase expenseDetailsDatabase;
    private LiveData<List<ExpensesDetails>> listLiveData;

    public ExpenseDetailsRespository(Application application) {
        expenseDetailsDatabase = ExpenseDetailsDatabase.getInstance(application);
        listLiveData = expenseDetailsDatabase.expenseDetailsDao().getExpenseDetailsDao();

    }

    public void insert(List<ExpensesDetails> expensesDetailsList) {
        new InsertAsynTask(expenseDetailsDatabase).execute(expensesDetailsList);
    }

    public LiveData<List<ExpensesDetails>> getExpenseDetailsRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<ExpensesDetails>, Void, Void> {
        private ExpenseDetailsDao expenseDetailsDao;

        InsertAsynTask(ExpenseDetailsDatabase expenseDetailsDatabase) {
            expenseDetailsDao = expenseDetailsDatabase.expenseDetailsDao();
        }

        @Override
        protected Void doInBackground(List<ExpensesDetails>... lists) {
            expenseDetailsDao.insertExpenseDetails(lists[0]);
            return null;
        }
    }
}
