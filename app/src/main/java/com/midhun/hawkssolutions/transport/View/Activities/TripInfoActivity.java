package com.midhun.hawkssolutions.transport.View.Activities;

import static com.midhun.hawkssolutions.transport.Config.Constants.API_KEY;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.midhun.hawkssolutions.transport.Config.Retrofit;
import com.midhun.hawkssolutions.transport.Modal.Status;
import com.midhun.hawkssolutions.transport.Modal.TripsInfo;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Repository.TripInfoRespository;
import com.midhun.hawkssolutions.transport.Response.TripInfoApiModel;
import com.midhun.hawkssolutions.transport.Utils.AddListener;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.ViewModal.TripInfoViewModal;
import com.midhun.hawkssolutions.transport.databinding.ActivityTripInfoBinding;
import com.ncorti.slidetoact.SlideToActView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripInfoActivity extends AppCompatActivity {

    ActivityTripInfoBinding binding;
    TripInfoRespository tripInfoRespository;
    TripInfoViewModal tripInfoViewModal;
    List<TripsInfo> tripsInfoList;
    String TRIP_ID;
    TextView start_loaction, end_location, start_state, end_state, location, type, number, date;
    ExtendedFloatingActionButton extendedFloatingActionButton;
    String base64Image;
    ImageView add_image, img_back;
    int imageChooserResult = 0;
    int fab;
    CardView search;
   TextView addExpenseTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTripInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        tripsInfoList = new ArrayList<>();


        MidhunUtils.setStatusBarIcon(TripInfoActivity.this, true);
        MidhunUtils.makeStatusBar(TripInfoActivity.this, R.color.white);
        MidhunUtils.showProgress(TripInfoActivity.this, true);


        ///views
        addExpenseTxt=binding.addExpenseTxt;
        search = binding.search;
        start_loaction = binding.startLocation;
        end_location = binding.endLocation;
        start_state = binding.startState;
        end_state = binding.endState;
        location = binding.location;
        type = binding.type;
        number = binding.number;
        date = binding.dare;
        extendedFloatingActionButton = binding.floatingActionButton2;
        img_back = binding.imgBack;


        TRIP_ID = getIntent().getExtras().getString("trip_id");


        addExpenseTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("trip_id", TRIP_ID);
                in.setClass(getApplicationContext(),AddExpenseActivity.class);
                startActivity(in);
                finish();
            }
        });

        tripInfoRespository = new TripInfoRespository(getApplication());
        tripInfoViewModal = new ViewModelProvider(this).get(TripInfoViewModal.class);
        tripInfoViewModal.listLiveData().observe(this, new Observer<List<TripsInfo>>() {
            @Override
            public void onChanged(List<TripsInfo> trips) {
                tripsInfoList.addAll(trips);
            }
        });


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fab == 0 || fab == 1) {
                    AlertDialog alertDialog = new AlertDialog.Builder(TripInfoActivity.this).create();
                    View view = getLayoutInflater().inflate(R.layout.custom_add_trip_details, null);
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    SlideToActView slideToActView = view.findViewById(R.id.example);
                    TextInputEditText km_txt;
                    km_txt = view.findViewById(R.id.km_txt);
                    TextView txt = view.findViewById(R.id.txt);
                    TextInputLayout input_km = view.findViewById(R.id.input_km);
                    add_image = view.findViewById(R.id.img_add);

                    if (fab == 1) {
                        input_km.setHelperText("Ending Kilometer");
                        input_km.setHint("End KM");
                        txt.setText("Add Ending Km Image");
                    }

                    add_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imagePicker();
                        }
                    });

                    slideToActView.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
                        @Override
                        public void onSlideComplete(@NonNull SlideToActView slideToActView) {
                            if (km_txt.getText().toString().isEmpty()) {
                                input_km.setError("enter km");
                                slideToActView.resetSlider();
                            } else if (imageChooserResult == 0) {
                                Toast.makeText(TripInfoActivity.this, "Add starting km image", Toast.LENGTH_SHORT).show();
                                slideToActView.resetSlider();
                            } else {
                                if (fab == 0) {
                                    startTrip(km_txt.getText().toString(), "", "1", base64Image, "");
                                } else if (fab == 1) {
                                    startTrip("", km_txt.getText().toString(), "2", "", base64Image);
                                } else {
                                    Toast.makeText(TripInfoActivity.this, "Trip Finished", Toast.LENGTH_SHORT).show();
                                }
                                alertDialog.hide();
                                MidhunUtils.showProgress(TripInfoActivity.this, true);


                            }
                        }
                    });
                    alertDialog.setView(view);
                    alertDialog.show();
                }
            }
        });

        getTripInfo();
    }

    private void getTripInfo() {
        Retrofit retrofit = new Retrofit();
        Call<TripInfoApiModel> call = retrofit.api.getTripInfo(API_KEY, API_KEY, TRIP_ID);
        call.enqueue(new Callback<TripInfoApiModel>() {
            @Override
            public void onResponse(Call<TripInfoApiModel> call, Response<TripInfoApiModel> response) {
                tripInfoRespository.insert(response.body().getTripDetailsList());
                start_loaction.setText(response.body().getTripDetailsList().get(0).getStart_location());
                end_location.setText(response.body().getTripDetailsList().get(0).getEnd_location());
                start_state.setText(response.body().getTripDetailsList().get(0).getStart_state());
                end_state.setText(response.body().getTripDetailsList().get(0).getEnd_state());
                location.setText(response.body().getTripDetailsList().get(0).getTrip());
                type.setText(response.body().getTripDetailsList().get(0).getVehicleType());
                number.setText(response.body().getTripDetailsList().get(0).getRegistration_number());
                date.setText(response.body().getTripDetailsList().get(0).getFrom_date() + " to " + response.body().getTripDetailsList().get(0).getTo_date());

                if (response.body().getTripDetailsList().get(0).getTrip_status().equalsIgnoreCase("0")) {
                    extendedFloatingActionButton.setText("START TRIP");
                    fab = 0;
                } else if (response.body().getTripDetailsList().get(0).getTrip_status().equalsIgnoreCase("1")) {
                    extendedFloatingActionButton.setText("END TRIP");
                    fab = 1;
                } else {
                    fab = 2;
                    extendedFloatingActionButton.setText("FINISHED");
                }
                MidhunUtils.progress.dismiss();
            }

            @Override
            public void onFailure(Call<TripInfoApiModel> call, Throwable t) {
                MidhunUtils.progress.dismiss();

            }
        });
    }


    private void imagePicker() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        SomeAction.launch(i);
    }

    ActivityResultLauncher<Intent> SomeAction
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        //setImage(pick, data);


                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap = null;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    this.getContentResolver(),
                                    selectedImageUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        add_image.setImageBitmap(
                                selectedImageBitmap);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        selectedImageBitmap.compress(Bitmap.CompressFormat.JPEG, 65, baos);
                        byte[] b = baos.toByteArray();
                        base64Image = "data:image/png;base64," + Base64.encodeToString(b, Base64.DEFAULT);
                        imageChooserResult = 100;

                    }
                }
            });


    private void startTrip(String startkm, String endkm, String status, String image, String image2) {
        Retrofit retrofit = new Retrofit();
        Call<Status> call = retrofit.api.updateKm(API_KEY, API_KEY, TRIP_ID, startkm, image, endkm, image2, status);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                MidhunUtils.progress.dismiss();
                getTripInfo();
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                MidhunUtils.progress.dismiss();
            }
        });


    }


}