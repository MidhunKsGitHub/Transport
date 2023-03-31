package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.Products;
import com.midhun.hawkssolutions.transport.Repository.ProductsRespository;

import java.util.List;

public class ProductViewModal extends AndroidViewModel {

    private ProductsRespository productsRespository;
    private LiveData<List<Products>> productApiModelLiveData;

    public ProductViewModal(@NonNull Application application) {
        super(application);
        productsRespository = new ProductsRespository(application);
        productApiModelLiveData = productsRespository.getAllProductsRepo();
    }

    public void insert(List<Products> productApiModel) {
        productsRespository.insert(productApiModel);
    }

    public LiveData<List<Products>> productApiModelLiveData() {
        return productApiModelLiveData;
    }

}
