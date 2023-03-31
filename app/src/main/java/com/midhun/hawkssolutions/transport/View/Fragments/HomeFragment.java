package com.midhun.hawkssolutions.transport.View.Fragments;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.midhun.hawkssolutions.transport.Adapter.TripAdapter;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.Repository.TripRespository;
import com.midhun.hawkssolutions.transport.Response.TripDetailsApiModel;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.ViewModal.TripViewModal;
import com.midhun.hawkssolutions.transport.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    TripViewModal tripViewModal;
    List<TripDetails> tripDetailsList;
    TripRespository tripRespository;
    FragmentHomeBinding fragmentHomeBinding;
    TextView txt;
    RecyclerView recyclerView;
    TripAdapter tripAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayout loading;
    LinearLayout c1;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        MidhunUtils.showProgress(getActivity(),true);
        tripDetailsList = new ArrayList<>();
        txt = fragmentHomeBinding.name;
        swipeRefreshLayout = fragmentHomeBinding.base;
        c1 = fragmentHomeBinding.c1;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTripDetails();
            }
        });

        txt.setText("Hi " + MidhunUtils.localData(getActivity(), "login", "NAME") + ",");

        recyclerView = fragmentHomeBinding.recyclerview;

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        tripAdapter = new TripAdapter(getActivity(), tripDetailsList, getActivity());
        recyclerView.setAdapter(tripAdapter);
        //// init repo
        tripRespository = new TripRespository(getActivity().getApplication());
        tripViewModal = new ViewModelProvider(this).get(TripViewModal.class);
        tripViewModal.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<TripDetails>>() {
            @Override
            public void onChanged(List<TripDetails> tripDetailsList1) {

                tripDetailsList.clear();
                tripDetailsList.addAll(tripDetailsList1);
                tripAdapter = new TripAdapter(getActivity(), tripDetailsList, getActivity());
                recyclerView.setAdapter(tripAdapter);
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }

            }
        });

        getTripDetails();

        return fragmentHomeBinding.getRoot();
    }

    private void getTripDetails() {
        Retrofit retrofit = new Retrofit();
        Call<TripDetailsApiModel> call = retrofit.api.getTripInfo(API_KEY, API_KEY, "9", "2023-03-15");
        call.enqueue(new Callback<TripDetailsApiModel>() {
            @Override
            public void onResponse(Call<TripDetailsApiModel> call, Response<TripDetailsApiModel> response) {
                tripRespository.insert(response.body().getTripDetailsList());
                MidhunUtils.progress.dismiss();
            }

            @Override
            public void onFailure(Call<TripDetailsApiModel> call, Throwable t) {
                MidhunUtils.progress.dismiss();
               // Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}