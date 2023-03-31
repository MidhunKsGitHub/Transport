package com.midhun.hawkssolutions.transport.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.midhun.hawkssolutions.transport.Modal.Products;

import java.util.List;

@Dao
public interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Products> productsList);

    @Query("SELECT * FROM products")
    LiveData<List<Products>> getAllProductsDao();

    @Query("DELETE FROM products")
    void deleteAll();
}
