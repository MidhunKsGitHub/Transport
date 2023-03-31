package com.midhun.hawkssolutions.transport.View.Fragments;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.ExpenseType;
import com.midhun.hawkssolutions.transport.Modal.Status;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Repository.ExpenseTypeRespository;
import com.midhun.hawkssolutions.transport.Repository.TripRespository;
import com.midhun.hawkssolutions.transport.Response.ExpenseTypeApiModel;
import com.midhun.hawkssolutions.transport.Response.TripDetailsApiModel;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.View.Activities.HomeActivity;
import com.midhun.hawkssolutions.transport.View.Activities.TripInfoActivity;
import com.midhun.hawkssolutions.transport.ViewModal.ExpenseTypeViewModal;
import com.midhun.hawkssolutions.transport.ViewModal.TripViewModal;
import com.midhun.hawkssolutions.transport.databinding.FragmentAddBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment {

    FragmentAddBinding binding;
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    List<String> stringList;
    List<String> expenseTypeStringList;
    ExpenseTypeViewModal expenseTypeViewModal;
    TripViewModal tripViewModal;
    List<TripDetails> tripDetailsList;
    List<ExpenseType> expenseTypeList;
    ExpenseTypeRespository expenseTypeRespository;
    TripRespository tripRespository;
    String TRIP_ID;
    String EXPENSE_TYPE_ID;
    ExtendedFloatingActionButton floatingActionButton;
    TextInputEditText date_txt;
    TextInputEditText trip_txt;
    TextInputEditText expense_txt;
    TextInputEditText quantity_txt;
    TextInputEditText note_text;
    TextInputEditText amount_txt;
    TextInputLayout input_date;
    TextInputLayout input_trip;
    final Calendar myCalendar = Calendar.getInstance();
    HashMap<String, Object> mapList = new HashMap<String, Object>();
    ArrayList<HashMap<String, Object>> expenseList = new ArrayList<>();
    JSONArray jsonArray;
    List<String> expenseStringArray;
    Intent intent = new Intent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        autoCompleteTextView = binding.autoComplete;
        autoCompleteTextView1 = binding.autoComplete1;
        floatingActionButton = binding.floatingActionButton;
        date_txt = binding.dateTxt;
        input_date = binding.inputDate;
        quantity_txt = binding.quantityTxt;
        amount_txt = binding.amountTxt;
        note_text = binding.noteTxt;
        input_trip = binding.inputTrip;
        expenseStringArray = new ArrayList<>();

        intent = getActivity().getIntent();

        if (intent.hasExtra("trip_id")) {
            input_trip.setVisibility(View.GONE);
            TRIP_ID = getActivity().getIntent().getExtras().getString("trip_id");
        }

        input_date.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, day);
                        String myFormat = "yyyy-MM-dd";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
                        date_txt.setText(dateFormat.format(myCalendar.getTime()));
                    }
                };

                new DatePickerDialog(getActivity(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mapList.put("expense_type_id", EXPENSE_TYPE_ID);
                mapList.put("expense", autoCompleteTextView1.getText().toString());
                mapList.put("quantity", quantity_txt.getText().toString());
                mapList.put("amount", amount_txt.getText().toString());
                mapList.put("expense_date", date_txt.getText().toString());
                mapList.put("note", note_text.getText().toString());
                expenseList.add(mapList);
                expenseStringArray.add(expenseList.toString());
                try {
                    jsonArray = new JSONArray(mapList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MidhunUtils.showProgress(getActivity(), true);
                addExpense();
            }
        });

        stringList = new ArrayList<>();
        expenseTypeStringList = new ArrayList<>();
        tripDetailsList = new ArrayList<>();
        expenseTypeList = new ArrayList<>();

        expenseTypeRespository = new ExpenseTypeRespository(getActivity().getApplication());
        expenseTypeViewModal = new ViewModelProvider(this).get(ExpenseTypeViewModal.class);
        expenseTypeViewModal.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<ExpenseType>>() {
            @Override
            public void onChanged(List<ExpenseType> expenseTypeList1) {
                expenseTypeList.clear();
                expenseTypeList.addAll(expenseTypeList1);
            }
        });

        tripRespository = new TripRespository(getActivity().getApplication());
        tripViewModal = new ViewModelProvider(this).get(TripViewModal.class);
        tripViewModal.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<TripDetails>>() {
            @Override
            public void onChanged(List<TripDetails> tripDetailsList1) {

                tripDetailsList.clear();
                tripDetailsList.addAll(tripDetailsList1);

            }
        });

        getTripDetails();
        getExpenseType();
        return binding.getRoot();
    }


    private void getTripDetails() {

        Retrofit retrofit = new Retrofit();
        Call<TripDetailsApiModel> call = retrofit.api.getTripInfo(API_KEY, API_KEY, MidhunUtils.localData(getActivity(), "login", "UID"), "2023-03-15");
        call.enqueue(new Callback<TripDetailsApiModel>() {
            @Override
            public void onResponse(Call<TripDetailsApiModel> call, Response<TripDetailsApiModel> response) {
                tripRespository.insert(response.body().getTripDetailsList());
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
            stringList.add(productsList.get(i).getTrip() + "  " + productsList.get(i).getFrom_date() + " to " + productsList.get(i).getTo_date());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.drop_down_item, stringList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                                    long id) {
                TRIP_ID = tripDetailsList.get(pos).getId();

            }
        });

    }

    private void getExpenseType() {
        Retrofit retrofit = new Retrofit();
        Call<ExpenseTypeApiModel> call = retrofit.api.getExpenseType(API_KEY, API_KEY, "expense_types");
        call.enqueue(new Callback<ExpenseTypeApiModel>() {

            @Override
            public void onResponse(Call<ExpenseTypeApiModel> call, Response<ExpenseTypeApiModel> response) {
                if (response.body() != null) {
                    expenseTypeRespository.insert(response.body().getTypes());
                    addToDropDownExpenseType(response.body().getTypes());
                }
            }

            @Override
            public void onFailure(Call<ExpenseTypeApiModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addToDropDownExpenseType(List<ExpenseType> productsList) {

        for (int i = 0; i < productsList.size(); i++) {
            expenseTypeStringList.add(productsList.get(i).getHead());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.drop_down_item, expenseTypeStringList);
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                                    long id) {
                EXPENSE_TYPE_ID = expenseTypeList.get(pos).getId();
            }
        });
    }

    private void addExpense() {
        Retrofit retrofit = new Retrofit();
        Call<Status> call = retrofit.api.addExpense(API_KEY, API_KEY, EXPENSE_TYPE_ID, autoCompleteTextView1.getText().toString(), quantity_txt.getText().toString(), amount_txt.getText().toString(), date_txt.getText().toString(), note_text.getText().toString(), TRIP_ID);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                MidhunUtils.progress.dismiss();

                if (intent.hasExtra("trip_id")) {
                    intent.setClass(getActivity(), TripInfoActivity.class);
                    startActivity(intent);
                    getActivity().finish();

                } else {
                    if (getActivity() instanceof HomeActivity) {
                        ((HomeActivity) getActivity()).gotoViewExpense();
                    }
                }

            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                MidhunUtils.progress.dismiss();
            }
        });
    }
}