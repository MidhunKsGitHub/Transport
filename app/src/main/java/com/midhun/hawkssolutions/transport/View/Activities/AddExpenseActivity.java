package com.midhun.hawkssolutions.transport.View.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.View.Fragments.AddFragment;

public class AddExpenseActivity extends AppCompatActivity {
    FrameLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        container = findViewById(R.id.container);
        getSupportActionBar().hide();
        MidhunUtils.makeStatusBar(AddExpenseActivity.this, R.color.white);
        MidhunUtils.setStatusBarIcon(AddExpenseActivity.this, true);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.container, AddFragment.class, null)
                    .commit();
        }
    }

}

