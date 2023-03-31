package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.ProfileDao;
import com.midhun.hawkssolutions.transport.Database.ProfileDatabase;
import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;

import java.util.List;

public class ProfileRespository {
    private ProfileDatabase profileDatabase;
    private LiveData<List<ProfileDetails>> listLiveData;

    public ProfileRespository(Application application) {
        profileDatabase = ProfileDatabase.getInstance(application);
        listLiveData = profileDatabase.profileDao().getProfileDetailsDao();

    }

    public  void insert(List<ProfileDetails> profileDetailsList) {
        new InsertAsynTask(profileDatabase).execute(profileDetailsList);
    }

    public LiveData<List<ProfileDetails>> getProfileDetailsRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<ProfileDetails>, Void, Void> {
        private ProfileDao profileDao;

        InsertAsynTask(ProfileDatabase profileDatabase) {
            profileDao = profileDatabase.profileDao();
        }

        @Override
        protected Void doInBackground(List<ProfileDetails>... lists) {
            profileDao.insert(lists[0]);
            return null;
        }
    }
}
