package com.midhun.hawkssolutions.transport.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.midhun.hawkssolutions.transport.Modal.Products;
import com.midhun.hawkssolutions.transport.R;


import java.util.List;

public class ProductApdater extends RecyclerView.Adapter<ProductApdater.ProductViewHolder> {
    Context context;
    List<Products> productsList;
    Activity activity;

    public ProductApdater(Context context, List<Products> productsList, Activity activity) {
        this.context = context;
        this.productsList = productsList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProductApdater.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_roe, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductApdater.ProductViewHolder holder, int position) {
        holder.name.setText(productsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
