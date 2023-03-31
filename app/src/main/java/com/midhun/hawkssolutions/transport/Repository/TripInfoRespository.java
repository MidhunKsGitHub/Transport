package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.TripDao;
import com.midhun.hawkssolutions.transport.Database.TripInfoDatabase;
import com.midhun.hawkssolutions.transport.Modal.TripsInfo;

import java.util.List;

public class TripInfoRespository {
    private TripInfoDatabase tripInfoDatabase;
    private LiveData<List<TripsInfo>> listLiveData;

    public TripInfoRespository(Application application) {
        tripInfoDatabase = TripInfoDatabase.getInstance(application);
        listLiveData = tripInfoDatabase.tripDao().getTripsDao();

    }

    public  void insert(List<TripsInfo> tripList) {
        new InsertAsynTask(tripInfoDatabase).execute(tripList);
    }

    public LiveData<List<TripsInfo>> getTripInfoRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<TripsInfo>, Void, Void> {
        private TripDao tripDao;

        InsertAsynTask(TripInfoDatabase tripInfoDatabase) {
            tripDao = tripInfoDatabase.tripDao();
        }

        @Override
        protected Void doInBackground(List<TripsInfo>... lists) {
            tripDao.insert(lists[0]);
            return null;
        }
    }
}
