package com.midhun.hawkssolutions.transport.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.midhun.hawkssolutions.transport.Dao.LoginDao;
import com.midhun.hawkssolutions.transport.Database.LoginDatabase;
import com.midhun.hawkssolutions.transport.Modal.Login;

import java.util.List;

public class LoginRespository {
    private LoginDatabase loginDatabase;
    private LiveData<List<Login>> listLiveData;

    public LoginRespository(Application application) {
        loginDatabase = LoginDatabase.getInstance(application);
        listLiveData = loginDatabase.loginDao().getLoginDetailsDDao();

    }

    public void insert(List<Login> loginList) {
        new InsertAsynTask(loginDatabase).execute(loginList);
    }

    public LiveData<List<Login>> getLoginRepo() {
        return listLiveData;
    }

    static class InsertAsynTask extends AsyncTask<List<Login>, Void, Void> {
        private LoginDao loginDao;

        InsertAsynTask(LoginDatabase loginDatabase) {
            loginDao = loginDatabase.loginDao();
        }

        @Override
        protected Void doInBackground(List<Login>... lists) {
            loginDao.insert(lists[0]);
            return null;
        }
    }
}
