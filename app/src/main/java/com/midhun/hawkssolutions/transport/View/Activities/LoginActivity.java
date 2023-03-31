package com.midhun.hawkssolutions.transport.View.Activities;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Repository.LoginRespository;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.ViewModal.LoginViewModal;
import com.midhun.hawkssolutions.transport.databinding.ActivityLoginBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding loginBinding;
    EditText phone;
    EditText password;
    CardView btn;
    LinearLayout c3;
    TextView tc;


    LoginViewModal loginViewModal;
    List<Login> userLoginList;
    LoginRespository loginRespository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());
        getSupportActionBar().hide();
        phone = loginBinding.phone;
        password = loginBinding.password;
        btn = loginBinding.btn;
        c3 = loginBinding.c3;
        tc = loginBinding.tc;
        userLoginList = new ArrayList<>();

        //initailizing respository

        loginRespository = new LoginRespository(getApplication());
        loginViewModal = new ViewModelProvider(this).get(LoginViewModal.class);
        loginViewModal.listLiveData().observe(this, new Observer<List<Login>>() {
            @Override
            public void onChanged(List<Login> loginList) {
                userLoginList.addAll(loginList);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setAlpha(.1f);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn.setAlpha(1f);
                    }
                }, 50);

                if (phone.getText().toString().isEmpty() || phone.getText().toString().equalsIgnoreCase("")) {
                    MidhunUtils.customSnackBar(tc, LoginActivity.this, "Phone number required");
                } else if (password.getText().toString().isEmpty() || password.getText().toString().equalsIgnoreCase("")) {
                    MidhunUtils.customSnackBar(tc, LoginActivity.this, "Password required");

                } else {

                    phone.setEnabled(false);
                    password.setEnabled(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            phone.setEnabled(true);
                            password.setEnabled(true);
                        }
                    }, 50);


                    MidhunUtils.showProgress(LoginActivity.this, true);
                    userLogin();
                }
            }
        });


    }

    private void userLogin() {
        Retrofit retrofit = new Retrofit();
        Call<List<Login>> call = retrofit.api.luserLogin(API_KEY, phone.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<List<Login>>() {
            @Override
            public void onResponse(Call<List<Login>> call, Response<List<Login>> response) {

                MidhunUtils.progress.dismiss();
                loginRespository.insert(response.body());
                if (response.body().get(0).getUser_type().equalsIgnoreCase("invalid")) {
                    MidhunUtils.customSnackBar(btn, LoginActivity.this, response.body().get(0).getError());
                } else if (response.body().get(0).getUser_type().equalsIgnoreCase("driver")) {
                    MidhunUtils.customSnackBar(btn, LoginActivity.this, "Login Successful");
                    MidhunUtils.addLocalData(LoginActivity.this,"login","UID",response.body().get(0).getId());
                    MidhunUtils.addLocalData(LoginActivity.this,"login","NAME",response.body().get(0).getName());
                    MidhunUtils.addLocalData(LoginActivity.this,"login","PHONE",response.body().get(0).getUsername());
                    loginViewModal.insert(response.body());
                    startActivity(new Intent(getApplication(),HomeActivity.class));
                } else {
                    MidhunUtils.customSnackBar(btn, LoginActivity.this, "Something Went Wrong !");
                }

            }

            @Override
            public void onFailure(Call<List<Login>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                MidhunUtils.progress.dismiss();

            }
        });
    }
}