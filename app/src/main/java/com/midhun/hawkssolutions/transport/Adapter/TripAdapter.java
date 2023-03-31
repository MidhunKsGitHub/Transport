package com.midhun.hawkssolutions.transport.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.midhun.hawkssolutions.transport.Modal.TripDetails;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.View.Activities.TripInfoActivity;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {
    Context context;
    List<TripDetails> tripDetailsList;
    Activity activity;

    public TripAdapter(Context context, List<TripDetails> tripDetailsList, Activity activity) {
        this.context = context;
        this.tripDetailsList = tripDetailsList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_trip_item, parent, false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        TripDetails tripDetails = tripDetailsList.get(position);
        holder.start_location.setText(tripDetails.getStart_location());
        holder.end_location.setText(tripDetails.getEnd_location());
        holder.start_date.setText(tripDetails.getFrom_date());
        holder.end_date.setText(tripDetails.getTo_date());
        holder.start_state.setText(tripDetails.getStart_state());
        holder.end_state.setText(tripDetails.getEnd_state());
        holder.body_type.setText(tripDetails.getVehicleType());
        holder.body_type.setSelected(true);

        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.setClass(context.getApplicationContext(), TripInfoActivity.class);
                in.putExtra("trip_id",tripDetails.getId());
                context.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tripDetailsList.size();
    }

    class TripViewHolder extends RecyclerView.ViewHolder {
        TextView start_location;
        TextView end_location;

        TextView start_state;
        TextView end_state;

        TextView start_date;
        TextView end_date;

        TextView trip;
        TextView number;

        TextView body_type;
        LinearLayout last;
        CardView base;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            start_location = itemView.findViewById(R.id.start_location);
            end_location = itemView.findViewById(R.id.end_location);
            start_date = itemView.findViewById(R.id.start_date);
            end_date = itemView.findViewById(R.id.end_date);
            start_state = itemView.findViewById(R.id.start_state);
            end_state = itemView.findViewById(R.id.end_state);
            body_type = itemView.findViewById(R.id.body_type);
            last = itemView.findViewById(R.id.last);
            base = itemView.findViewById(R.id.base);

        }
    }
}
