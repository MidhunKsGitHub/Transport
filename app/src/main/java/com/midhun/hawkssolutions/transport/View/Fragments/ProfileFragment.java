package com.midhun.hawkssolutions.transport.View.Fragments;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;
import static com.midhun.hawkssolutions.transport.Config.Constants.IMG_URL;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Repository.ProfileRespository;
import com.midhun.hawkssolutions.transport.Response.ProfileDetailsApiModel;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.View.Activities.HomeActivity;
import com.midhun.hawkssolutions.transport.ViewModal.ProfileViewModal;
import com.midhun.hawkssolutions.transport.databinding.FragmentProfileBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    ProfileViewModal profileViewModal;
    ProfileRespository profileRespository;
    List<ProfileDetails> profileDetailsList;
    String UID;
    TextView username,phone,email,address,pan,aadhar,salary;
    ImageView pro,img_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        UID = MidhunUtils.localData(getActivity(), "login", "UID");
        profileDetailsList = new ArrayList<>();
        username=binding.username;
        phone=binding.phone;
        email=binding.email;
        address=binding.address;
        pan=binding.pan;
        aadhar=binding.aadhar;
        salary=binding.salary;
        pro=binding.pro;
        img_back=binding.imgBack;

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof HomeActivity) {
                    ((HomeActivity) getActivity()).onBackPressed();
                }
            }
        });

        profileRespository = new ProfileRespository(getActivity().getApplication());
        profileViewModal = new ViewModelProvider(this).get(ProfileViewModal.class);
        profileViewModal.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<ProfileDetails>>() {
            @Override
            public void onChanged(List<ProfileDetails> profileDetailsList1) {
                profileDetailsList.clear();
                profileDetailsList.addAll(profileDetailsList1);
                 getProfileDetails();
            }
        });
        getProfileDetails();
        return binding.getRoot();
    }

    private void getProfileDetails() {
        Retrofit retrofit = new Retrofit();
        Call<ProfileDetailsApiModel> call = retrofit.api.getProfileDetails(API_KEY, API_KEY, UID);
        call.enqueue(new Callback<ProfileDetailsApiModel>() {
            @Override
            public void onResponse(Call<ProfileDetailsApiModel> call, Response<ProfileDetailsApiModel> response) {

                profileRespository.insert(response.body().getProfileDetails());
                username.setText("Username : "+response.body().getProfileDetails().get(0).getName());
                phone.setText("Phone : "+response.body().getProfileDetails().get(0).getContact());
                email.setText("Email : "+response.body().getProfileDetails().get(0).getEmail());
                address.setText("Address : "+response.body().getProfileDetails().get(0).getAddress());
                pan.setText("Pan no : "+response.body().getProfileDetails().get(0).getPan_no());
                aadhar.setText("Aadhar no : "+response.body().getProfileDetails().get(0).getAdhaar_no());
                salary.setText("Salary : Rs."+response.body().getProfileDetails().get(0).getMypackage());
                String img_url=IMG_URL+response.body().getProfileDetails().get(0).getImage();
                try {
                    Glide.with(getActivity())
                            .load(img_url)
                            .transition(withCrossFade())
                            .apply(new RequestOptions()
                                    //.override(60, 60)
                                    .placeholder(R.drawable.water)
                                    .error(R.drawable.boxtruck).centerCrop()
                            )
                            .into(pro);
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ProfileDetailsApiModel> call, Throwable t) {

            }
        });
    }


}