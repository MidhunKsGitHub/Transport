package com.midhun.hawkssolutions.transport.Utils;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.midhun.hawkssolutions.transport.R;

import java.util.Date;


final public class MidhunUtils {

    public static ProgressDialog progress;

    public interface Callback {
        void refreshList();
    }

    private static Callback mCallback;
    static ActionListener actionListener;

    public void listener(ActionListener listener) {
        actionListener = listener;
    }

    public void setListener(Callback callBack) {
        mCallback = callBack;
    }


    public static void showSnackbar(LinearLayout parentLayout, Context context, boolean action, String text, String close) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (action) {
                Snackbar.make(parentLayout, text, Snackbar.LENGTH_LONG)
                        .setAction(close, new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                mCallback.refreshList();
                                actionListener.snackbarOnClick();
                            }
                        })
                        .setActionTextColor(context.getColor(android.R.color.holo_red_light))
                        .show();
            } else {
                Snackbar.make(parentLayout, text, Snackbar.LENGTH_LONG).show();
            }
        }
    }

    public static void showMessage(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static void round(View view, int color, int color2, float radius) {
        GradientDrawable shape = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[]{
                        color,
                        color2
                });
        shape.setCornerRadius(radius);


        // now find your view and add background to it
        //View view = (LinearLayout) findViewById( R.id.);
        view.setBackground(shape);
    }

    public static void makeStatusBar(Activity activity, int color1) {

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(activity.getResources().getColor(color1));
        }
    }

    public static void setStatusBarIcon(Activity activity, boolean bw) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = activity.getWindow().getDecorView();


            if (bw) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                decor.setSystemUiVisibility(0);
            }
        }
    }

    public static void changeProgressBarColor(ProgressBar progressBar, int color, Activity activity) {
        progressBar.getIndeterminateDrawable().setColorFilter(activity.getResources().getColor(color), PorterDuff.Mode.SRC_IN);

    }


    public static void showSnackBarMsg(Context context, View view, String text, String close) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                    .setAction(close, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .setActionTextColor(context.getColor(android.R.color.holo_red_light))
                    .show();
        }
    }


    public static void showProgress(Context context, boolean t) {

        progress = ProgressDialog.show(context, null, null, true);
        progress.setContentView(R.layout.progress_layout);
        progress.setCancelable(t);
        progress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LottieAnimationView load = progress.findViewById(R.id.load);
        load.setAnimation(R.raw.transport);
        load.playAnimation();

        progress.show();

    }

    public static String localData(Activity activity, String sname, String key) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(sname, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public static String localDataCtx(Context activity, String sname, String key) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(sname, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public static void addLocalData(Context context, String sname, String name, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sname, Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString(name, key);
        myEdit.commit();
    }

    public static void changeStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(activity.getResources().getColor(color));
        }

    }

    public static void colorFilter(Activity activity, ImageView image, int color) {
        image.setColorFilter(activity.getResources().getColor(color));

    }

    public static void colorFilterContex(Context activity, ImageView image, int color) {
        image.setColorFilter(activity.getResources().getColor(color));

    }

    public static void gradientUi(View view, float f, int color, int color2) {
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{color, color2});
        gd.setCornerRadius(f);

        view.setBackgroundDrawable(gd);
    }

    public static void customSnackBar(View v, Activity activity, String msg) {
        // create an instance of the snackbar
        final Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), "", Snackbar.LENGTH_LONG);

        // inflate the custom_snackbar_view created previously
        View customSnackView = activity.getLayoutInflater().inflate(R.layout.custom_snackbar, null);

        // set the background of the default snackbar as transparent
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        //snackbar.setAnchorView(v);
        // now change the layout of the snackbar
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

        // set padding of the all corners as 0
        snackbarLayout.setPadding(0, 0, 0, 0);

        // register the button from the custom_snackbar_view layout file
        TextView item = customSnackView.findViewById(R.id.item);
        TextView view = customSnackView.findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        item.setText(msg);

        LinearLayout cart = customSnackView.findViewById(R.id.cart);
        ImageView img = customSnackView.findViewById(R.id.img);
        MidhunUtils.colorFilter(activity, img, R.color.grey);


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        snackbarLayout.addView(customSnackView, 0);

        snackbar.show();
    }

    public static void customSnackBarLogin(View v, Activity activity) {
        // create an instance of the snackbar
        final Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), "", Snackbar.LENGTH_LONG);

        // inflate the custom_snackbar_view created previously
        View customSnackView = activity.getLayoutInflater().inflate(R.layout.custom_snackbar_login, null);

        // set the background of the default snackbar as transparent
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        snackbar.setAnchorView(v);
        // now change the layout of the snackbar
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

        // set padding of the all corners as 0
        snackbarLayout.setPadding(0, 0, 0, 0);

        // register the button from the custom_snackbar_view layout file
        TextView bGotoWebsite = customSnackView.findViewById(R.id.item);

        LinearLayout cart = customSnackView.findViewById(R.id.cart);
        ImageView img = customSnackView.findViewById(R.id.img);
        MidhunUtils.colorFilter(activity, img, R.color.white);
        // now handle the same button with onClickListener
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent();
//                in.setClass(activity, SignInActivity.class);
//                activity.startActivity(in);
            }

        });

        // add the custom snack bar layout to snackbar layout
        snackbarLayout.addView(customSnackView, 0);

        snackbar.show();
    }

    public static long printDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();


        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
        return elapsedDays;
    }


    //block screenshot
    public static void blockScreenShot(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
    }
}
