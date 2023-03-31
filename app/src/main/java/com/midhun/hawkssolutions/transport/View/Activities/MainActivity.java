package com.midhun.hawkssolutions.transport.View.Activities;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.midhun.hawkssolutions.transport.Adapter.ProductApdater;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.Products;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Repository.ProductsRespository;
import com.midhun.hawkssolutions.transport.Response.ProductApiModel;
import com.midhun.hawkssolutions.transport.ViewModal.ProductViewModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProductViewModal productViewModal;
    private RecyclerView recyclerView;
    private List<Products> productsList;
    private ProductsRespository productsRespository;
    private ProductApdater productApdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        productsRespository = new ProductsRespository(getApplication());
        productsList = new ArrayList<>();
        productApdater = new ProductApdater(MainActivity.this, productsList, MainActivity.this);
        recyclerView.setAdapter(productApdater);
        productViewModal = new ViewModelProvider(this).get(ProductViewModal.class);
        networkRequest1();
        productViewModal.productApiModelLiveData().observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                productsList.addAll(products);
                productApdater = new ProductApdater(MainActivity.this, productsList, MainActivity.this);
                recyclerView.setAdapter(productApdater);
            }
        });

    }

    private void networkRequest1() {

        Retrofit retrofit = new Retrofit();
        Call<ProductApiModel> call = retrofit.api.getAllProducts(API_KEY, API_KEY, "products", "0", "20");
        call.enqueue(new Callback<ProductApiModel>() {
            @Override
            public void onResponse(Call<ProductApiModel> call, Response<ProductApiModel> response) {
                productsRespository.insert(response.body().PList());


            }

            @Override
            public void onFailure(Call<ProductApiModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
