package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.TripDetailsDao;
import com.midhun.hawkssolutions.transport.Database.TripDatabase;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;

import java.util.List;

public class TripRespository {
    private TripDatabase tripDatabase;
    private LiveData<List<TripDetails>> listLiveData;

    public TripRespository(Application application) {
        tripDatabase = TripDatabase.getInstance(application);
        listLiveData = tripDatabase.tripDao().getTripDetailsDao();

    }

    public  void insert(List<TripDetails> tripDetailsList) {
        new InsertAsynTask(tripDatabase).execute(tripDetailsList);
    }

    public LiveData<List<TripDetails>> getTripRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<TripDetails>, Void, Void> {
        private TripDetailsDao tripDetailsDao;

        InsertAsynTask(TripDatabase tripDatabase) {
            tripDetailsDao = tripDatabase.tripDao();
        }

        @Override
        protected Void doInBackground(List<TripDetails>... lists) {
            tripDetailsDao.insert(lists[0]);
            return null;
        }
    }
}
