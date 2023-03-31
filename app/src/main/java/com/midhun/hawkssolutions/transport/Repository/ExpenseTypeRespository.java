package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.ExpenseTypeDao;
import com.midhun.hawkssolutions.transport.Database.ExpenseTypeDatabase;
import com.midhun.hawkssolutions.transport.Modal.ExpenseType;

import java.util.List;

public class ExpenseTypeRespository {
    private ExpenseTypeDatabase expenseTypeDatabase;
    private LiveData<List<ExpenseType>> listLiveData;

    public ExpenseTypeRespository(Application application) {
        expenseTypeDatabase = ExpenseTypeDatabase.getInstance(application);
        listLiveData = expenseTypeDatabase.expenseTypeDao().getExpenseTypeDao();

    }

    public void insert(List<ExpenseType> expenseTypeList) {
        new InsertAsynTask(expenseTypeDatabase).execute(expenseTypeList);
    }

    public LiveData<List<ExpenseType>> getExpenseTypeRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<ExpenseType>, Void, Void> {
        private ExpenseTypeDao expenseTypeDao;

        InsertAsynTask(ExpenseTypeDatabase expenseTypeDatabase) {
            expenseTypeDao = expenseTypeDatabase.expenseTypeDao();
        }

        @Override
        protected Void doInBackground(List<ExpenseType>... lists) {
            expenseTypeDao.insertExoenseType(lists[0]);
            return null;
        }
    }
}
