package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Modal.Products;

import java.util.List;

@Dao
public interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Login> loginList);

    @Query("SELECT * FROM LoginTable")
    LiveData<List<Login>> getLoginDetailsDDao();

    @Query("DELETE FROM LoginTable")
    void deleteAll();

}
