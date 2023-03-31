package com.midhun.hawkssolutions.transport.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.databinding.CustomAddTripDetailsBinding;

public class CustomDialog extends DialogFragment {
CustomAddTripDetailsBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=CustomAddTripDetailsBinding.inflate(inflater,container,false);
        getDialog().setTitle("Sample");

        return binding.getRoot();
    }


}
