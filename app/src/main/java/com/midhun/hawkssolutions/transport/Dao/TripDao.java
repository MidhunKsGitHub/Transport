package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.TripsInfo;

import java.util.List;

@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TripsInfo> tripDetailsList);

    @Query("SELECT * FROM TripsInfo")
    LiveData<List<TripsInfo>> getTripsDao();

    @Query("DELETE FROM TripsInfo")
    void deleteAll();
}
