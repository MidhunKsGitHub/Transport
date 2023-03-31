package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.ExpenseType;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.Repository.ExpenseTypeRespository;
import com.midhun.hawkssolutions.transport.Repository.TripRespository;

import java.util.List;

public class ExpenseTypeViewModal extends AndroidViewModel {

    private ExpenseTypeRespository expenseTypeRespository;
    private LiveData<List<ExpenseType>> listLiveData;

    public ExpenseTypeViewModal(@NonNull Application application) {
        super(application);
        expenseTypeRespository = new ExpenseTypeRespository(application);
        listLiveData = expenseTypeRespository.getExpenseTypeRepo();
    }

    public void insert(List<ExpenseType> expenseTypeList) {
        expenseTypeRespository.insert(expenseTypeList);
    }

    public LiveData<List<ExpenseType>> listLiveData() {
        return listLiveData;
    }

}
