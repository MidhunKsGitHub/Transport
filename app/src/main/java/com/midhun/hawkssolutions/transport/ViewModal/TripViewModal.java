package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.Repository.LoginRespository;
import com.midhun.hawkssolutions.transport.Repository.TripRespository;

import java.util.List;

public class TripViewModal extends AndroidViewModel {

    private TripRespository tripRespository;
    private LiveData<List<TripDetails>> listLiveData;

    public TripViewModal(@NonNull Application application) {
        super(application);
        tripRespository = new TripRespository(application);
        listLiveData = tripRespository.getTripRepo();
    }

    public void insert(List<TripDetails> tripDetailsList) {
        tripRespository.insert(tripDetailsList);
    }

    public LiveData<List<TripDetails>> listLiveData() {
        return listLiveData;
    }

}
