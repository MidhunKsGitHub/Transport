package com.midhun.hawkssolutions.transport.View.Fragments;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.midhun.hawkssolutions.transport.Adapter.ViewExpenseAdapter;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Repository.ExpenseDetailsRespository;
import com.midhun.hawkssolutions.transport.Response.ExpenseDetailsApiModel;
import com.midhun.hawkssolutions.transport.Response.TripDetailsApiModel;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.ViewModal.ExpenseDetailsViewModal;
import com.midhun.hawkssolutions.transport.databinding.FragmentExpenseBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExpenseFragment extends Fragment {

    FragmentExpenseBinding binding;
    RecyclerView recyclerView;
    ExpenseDetailsRespository expenseDetailsRespository;
    List<ExpensesDetails> expensesDetailsList;
    ExpenseDetailsViewModal expenseDetailsViewModal;
    ViewExpenseAdapter viewExpenseAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    List<String> stringList;
    List<TripDetails> tripDetailsList;
    AutoCompleteTextView autoCompleteTextView;
    String TRIP_ID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExpenseBinding.inflate(inflater, container, false);

        swipeRefreshLayout = binding.swiperefresh;
        autoCompleteTextView = binding.autoComplete;
        expensesDetailsList = new ArrayList<>();
        stringList = new ArrayList<>();
        tripDetailsList = new ArrayList<>();

        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        viewExpenseAdapter = new ViewExpenseAdapter(getActivity(), expensesDetailsList);
        recyclerView.setAdapter(viewExpenseAdapter);

        expenseDetailsRespository = new ExpenseDetailsRespository(getActivity().getApplication());
        expenseDetailsViewModal = new ViewModelProvider(this).get(ExpenseDetailsViewModal.class);
        expenseDetailsViewModal.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<ExpensesDetails>>() {
            @Override
            public void onChanged(List<ExpensesDetails> expensesDetailsList1) {

            }
        });

        getTripDetails();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewExpense();
            }
        });

        return binding.getRoot();
    }

    private void viewExpense() {
        Retrofit retrofit = new Retrofit();
        Call<ExpenseDetailsApiModel> call = retrofit.api.getTripExpense(API_KEY, API_KEY, TRIP_ID);
        call.enqueue(new Callback<ExpenseDetailsApiModel>() {
            @Override
            public void onResponse(Call<ExpenseDetailsApiModel> call, Response<ExpenseDetailsApiModel> response) {
                expensesDetailsList.clear();
                expensesDetailsList.addAll(response.body().getExpenses());

                recyclerView.setAdapter(viewExpenseAdapter);
                viewExpenseAdapter.notifyDataSetChanged();
                MidhunUtils.progress.dismiss();

                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }

            }

            @Override
            public void onFailure(Call<ExpenseDetailsApiModel> call, Throwable t) {

            }
        });
    }


    private void getTripDetails() {

        Retrofit retrofit = new Retrofit();
        Call<TripDetailsApiModel> call = retrofit.api.getTripInfo(API_KEY, API_KEY, MidhunUtils.localData(getActivity(), "login", "UID"), "2023-03-15");
        call.enqueue(new Callback<TripDetailsApiModel>() {
            @Override
            public void onResponse(Call<TripDetailsApiModel> call, Response<TripDetailsApiModel> response) {
                tripDetailsList.clear();
                tripDetailsList.addAll(response.body().getTripDetailsList());
                addToDropDown(response.body().getTripDetailsList());
            }

            @Override
            public void onFailure(Call<TripDetailsApiModel> call, Throwable t) {

                // Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addToDropDown(List<TripDetails> productsList) {
        for (int i = 0; i < productsList.size(); i++) {
            //  stringList.add(productsList.get(i).getTrip() + "  " + productsList.get(i).getFrom_date() + " to " + productsList.get(i).getTo_date());
            stringList.add(productsList.get(i).getTrip());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.drop_down_item, stringList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                                    long id) {
                TRIP_ID = tripDetailsList.get(pos).getId();
                MidhunUtils.showProgress(getActivity(),true);
                viewExpense();
                //   Toast.makeText(getActivity(), TRIP_ID, Toast.LENGTH_SHORT).show();


            }
        });

    }

}