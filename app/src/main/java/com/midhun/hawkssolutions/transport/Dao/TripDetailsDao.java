package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.TripDetails;

import java.util.List;

@Dao
public interface TripDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TripDetails> tripDetailsList);

    @Query("SELECT * FROM TripInfo")
    LiveData<List<TripDetails>> getTripDetailsDao();

    @Query("DELETE FROM TripInfo")
    void deleteAll();

}
