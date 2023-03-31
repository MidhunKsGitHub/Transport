package com.midhun.hawkssolutions.transport.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Utils.AddListener;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;
import com.midhun.hawkssolutions.transport.View.Fragments.AddFragment;
import com.midhun.hawkssolutions.transport.View.Fragments.ExpenseFragment;
import com.midhun.hawkssolutions.transport.View.Fragments.HomeFragment;
import com.midhun.hawkssolutions.transport.View.Fragments.ProfileFragment;
import com.midhun.hawkssolutions.transport.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding activityHomeBinding;
    FrameLayout container;
    Fragment homeFragment;
    Fragment expenseFragment;
    Fragment addFragment;
    Fragment profileFragment;
    FragmentManager fm;
    ImageView ic_home;
    LinearLayout home_c, expense_c, add_c, profile_c;
    ImageView ic_expense, ic_add, ic_profile;
    CardView home_bar, expense_bar, add_bar, profile_bar;
    boolean isHome = true;
    int backPressed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());

        container = activityHomeBinding.container;
        ic_home = activityHomeBinding.icHome;
        home_c = activityHomeBinding.homeC;
        expense_c = activityHomeBinding.expenseC;
        add_c = activityHomeBinding.addC;
        profile_c = activityHomeBinding.profileC;
        ic_expense = activityHomeBinding.icExpense;
        ic_add = activityHomeBinding.icAdd;
        ic_profile = activityHomeBinding.icProfile;

        home_bar = activityHomeBinding.homeBar;
        expense_bar = activityHomeBinding.expenseBar;
        add_bar = activityHomeBinding.addBar;
        profile_bar = activityHomeBinding.profileBar;

        //color filter

        MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.primary_blue_dark);
        getSupportActionBar().hide();


        homeFragment = new HomeFragment();
        expenseFragment = new ExpenseFragment();
        addFragment = new AddFragment();
        profileFragment = new ProfileFragment();

        fm = getSupportFragmentManager();
        if (savedInstanceState == null) {

            fm.beginTransaction().add(R.id.container, homeFragment, "1").commit();
            fm.beginTransaction().add(R.id.container, expenseFragment, "2").hide(expenseFragment).commit();
            fm.beginTransaction().add(R.id.container, addFragment, "3").hide(addFragment).commit();
            fm.beginTransaction().add(R.id.container, profileFragment, "4").hide(addFragment).commit();

            fm.beginTransaction().hide(expenseFragment).hide(addFragment).hide(profileFragment).show(homeFragment).commit();

        }

        home_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHome = true;
                MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.primary_blue_dark);
                MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.black);
                MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.black);


                home_bar.setVisibility(View.VISIBLE);
                expense_bar.setVisibility(View.INVISIBLE);
                add_bar.setVisibility(View.INVISIBLE);
                profile_bar.setVisibility(View.INVISIBLE);
                fm.beginTransaction().hide(expenseFragment).hide(addFragment).hide(profileFragment).show(homeFragment).commit();

                MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.primary_blue);
                MidhunUtils.setStatusBarIcon(HomeActivity.this, false);

            }
        });

        expense_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHome = false;
                MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.primary_blue_dark);
                MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.black);
                MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.black);


                expense_bar.setVisibility(View.VISIBLE);
                home_bar.setVisibility(View.INVISIBLE);
                add_bar.setVisibility(View.INVISIBLE);
                profile_bar.setVisibility(View.INVISIBLE);

                fm.beginTransaction().hide(homeFragment).hide(addFragment).hide(profileFragment).show(expenseFragment).commit();

                MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.white);
                MidhunUtils.setStatusBarIcon(HomeActivity.this, true);
            }
        });

        add_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHome = false;
                MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.primary_blue_dark);
                MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.black);
                MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.black);


                add_bar.setVisibility(View.VISIBLE);
                home_bar.setVisibility(View.INVISIBLE);
                expense_bar.setVisibility(View.INVISIBLE);
                profile_bar.setVisibility(View.INVISIBLE);

                fm.beginTransaction().hide(homeFragment).hide(expenseFragment).hide(profileFragment).show(addFragment).commit();


                MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.white);
                MidhunUtils.setStatusBarIcon(HomeActivity.this, true);

            }
        });

        profile_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHome = false;
                MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.black);
                MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.black);
                MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.black);


                profile_bar.setVisibility(View.VISIBLE);
                home_bar.setVisibility(View.INVISIBLE);
                add_bar.setVisibility(View.INVISIBLE);
                expense_bar.setVisibility(View.INVISIBLE);

                fm.beginTransaction().hide(homeFragment).hide(addFragment).hide(expenseFragment).show(profileFragment).commit();

                MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.white);
                MidhunUtils.setStatusBarIcon(HomeActivity.this, true);

            }
        });


    }


    public void gotoViewExpense() {
        isHome = false;
        MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.primary_blue_dark);
        MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.black);
        MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.black);


        expense_bar.setVisibility(View.VISIBLE);
        home_bar.setVisibility(View.INVISIBLE);
        add_bar.setVisibility(View.INVISIBLE);
        profile_bar.setVisibility(View.INVISIBLE);

        fm.beginTransaction().hide(homeFragment).hide(addFragment).hide(profileFragment).show(expenseFragment).commit();

        MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.white);
        MidhunUtils.setStatusBarIcon(HomeActivity.this, true);

    }

    public void gotoAddExpense() {
        isHome = false;
        MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.primary_blue_dark);
        MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.black);
        MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.black);


        add_bar.setVisibility(View.VISIBLE);
        home_bar.setVisibility(View.INVISIBLE);
        expense_bar.setVisibility(View.INVISIBLE);
        profile_bar.setVisibility(View.INVISIBLE);

        fm.beginTransaction().hide(homeFragment).hide(expenseFragment).hide(profileFragment).show(addFragment).commit();


        MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.white);
        MidhunUtils.setStatusBarIcon(HomeActivity.this, true);

    }

    @Override
    public void onBackPressed() {

        backPressed++;


        if (isHome == false) {

            MidhunUtils.colorFilter(HomeActivity.this, ic_home, R.color.primary_blue_dark);
            MidhunUtils.colorFilter(HomeActivity.this, ic_expense, R.color.black);
            MidhunUtils.colorFilter(HomeActivity.this, ic_add, R.color.black);


            home_bar.setVisibility(View.VISIBLE);
            expense_bar.setVisibility(View.INVISIBLE);
            add_bar.setVisibility(View.INVISIBLE);
            profile_bar.setVisibility(View.INVISIBLE);
            fm.beginTransaction().hide(expenseFragment).hide(addFragment).hide(profileFragment).show(homeFragment).commit();

            MidhunUtils.changeStatusBarColor(HomeActivity.this, R.color.primary_blue);
            MidhunUtils.setStatusBarIcon(HomeActivity.this, false);

            isHome = true;

        } else if (isHome == true) {
            finishAffinity();
        }

    }


}