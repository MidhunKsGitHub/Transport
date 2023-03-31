package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;

import java.util.List;

@Dao
public interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ProfileDetails> profileDetailsList);

    @Query("SELECT * FROM profile")
    LiveData<List<ProfileDetails>> getProfileDetailsDao();

    @Query("DELETE FROM profile")
    void deleteAllProfile();
}
