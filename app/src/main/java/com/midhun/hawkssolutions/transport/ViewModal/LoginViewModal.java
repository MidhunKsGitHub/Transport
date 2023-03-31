package com.midhun.hawkssolutions.transport.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Modal.Products;
import com.midhun.hawkssolutions.transport.Repository.LoginRespository;
import com.midhun.hawkssolutions.transport.Repository.ProductsRespository;

import java.util.List;

public class LoginViewModal extends AndroidViewModel {

    private LoginRespository loginRespository;
    private LiveData<List<Login>> listLiveData;

    public LoginViewModal(@NonNull Application application) {
        super(application);
        loginRespository = new LoginRespository(application);
        listLiveData = loginRespository.getLoginRepo();
    }

    public void insert(List<Login> loginList) {
        loginRespository.insert(loginList);
    }

    public LiveData<List<Login>> listLiveData() {
        return listLiveData;
    }

}
