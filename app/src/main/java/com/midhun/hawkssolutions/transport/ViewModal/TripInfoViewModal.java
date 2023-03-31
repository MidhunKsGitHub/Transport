package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.TripsInfo;
import com.midhun.hawkssolutions.transport.Repository.TripInfoRespository;

import java.util.List;

public class TripInfoViewModal extends AndroidViewModel {

    private TripInfoRespository tripInfoRespository;
    private LiveData<List<TripsInfo>> listLiveData;

    public TripInfoViewModal(@NonNull Application application) {
        super(application);
        tripInfoRespository = new TripInfoRespository(application);
        listLiveData = tripInfoRespository.getTripInfoRepo();
    }

    public void insert(List<TripsInfo> tripList) {
        tripInfoRespository.insert(tripList);
    }

    public LiveData<List<TripsInfo>> listLiveData() {
        return listLiveData;
    }

}
