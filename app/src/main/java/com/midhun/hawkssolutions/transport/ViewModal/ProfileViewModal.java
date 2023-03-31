package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;
import com.midhun.hawkssolutions.transport.Repository.ProfileRespository;

import java.util.List;

public class ProfileViewModal extends AndroidViewModel {

    private ProfileRespository profileRespository;
    private LiveData<List<ProfileDetails>> listLiveData;

    public ProfileViewModal(@NonNull Application application) {
        super(application);
        profileRespository = new ProfileRespository(application);
        listLiveData = profileRespository.getProfileDetailsRepo();
    }

    public void insert(List<ProfileDetails> profileDetailsList) {
        profileRespository.insert(profileDetailsList);
    }

    public LiveData<List<ProfileDetails>> listLiveData() {
        return listLiveData;
    }

}
