package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;
import com.midhun.hawkssolutions.transport.Repository.ExpenseDetailsRespository;

import java.util.List;

public class ExpenseDetailsViewModal extends AndroidViewModel {

    private ExpenseDetailsRespository expenseDetailsRespository;
    private LiveData<List<ExpensesDetails>> listLiveData;

    public ExpenseDetailsViewModal(@NonNull Application application) {
        super(application);
        expenseDetailsRespository = new ExpenseDetailsRespository(application);
        listLiveData = expenseDetailsRespository.getExpenseDetailsRepo();
    }

    public void insert(List<ExpensesDetails> expensesDetailsList) {
        expenseDetailsRespository.insert(expensesDetailsList);
    }

    public LiveData<List<ExpensesDetails>> listLiveData() {
        return listLiveData;
    }

}
