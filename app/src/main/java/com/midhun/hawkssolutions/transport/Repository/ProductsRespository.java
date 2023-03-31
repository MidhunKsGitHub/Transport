package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.ProductsDao;
import com.midhun.hawkssolutions.transport.Modal.Products;
import com.midhun.hawkssolutions.transport.Database.ProductDatabase;

import java.util.List;

public class ProductsRespository {
    private ProductDatabase productDatabase;
    private LiveData<List<Products>> productApiModelLiveData;

    public ProductsRespository(Application application)
    {
        productDatabase=ProductDatabase.getInstance(application);
        productApiModelLiveData=productDatabase.productsDao().getAllProductsDao();

    }

    public void insert(List<Products> productsList){
     new InsertAsynTask(productDatabase).execute(productsList);
    }

    public LiveData<List<Products>> getAllProductsRepo()
    {
        return productApiModelLiveData;
    }

   static class InsertAsynTask extends AsyncTask<List<Products>,Void,Void>{
        private ProductsDao productsDao;
         InsertAsynTask(ProductDatabase productDatabase)
         {
             productsDao=productDatabase.productsDao();
         }

       @Override
       protected Void doInBackground(List<Products>... lists) {
             productsDao.insert(lists[0]);
           return null;
       }
   }
}
