package com.midhun.hawkssolutions.transport.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;
import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.databinding.CustomViewExpenseBinding;

import java.util.List;

public class ViewExpenseAdapter extends RecyclerView.Adapter<ViewExpenseAdapter.ExpenseViewHolder> {
    Context context;
    List<ExpensesDetails> expensesDetailsList;

    public ViewExpenseAdapter(Context context, List<ExpensesDetails> expensesDetailsList) {
        this.context = context;
        this.expensesDetailsList = expensesDetailsList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.custom_view_expense,parent,false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        ExpensesDetails expensesDetails=expensesDetailsList.get(position);
        holder.trip.setText(expensesDetails.getTrip());
        holder.expense.setText(expensesDetails.getExpense());
        holder.amount.setText("Rs. "+expensesDetails.getAmount());
        holder.date.setText(expensesDetails.getExpense_date());
        holder.trip.setSelected(true);
        holder.expense.setSelected(true);
        holder.amount.setSelected(true);
        holder.date.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return expensesDetailsList.size();
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder{
        TextView trip,expense,amount,date;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            trip=itemView.findViewById(R.id.trip);
            expense=itemView.findViewById(R.id.expense);
            amount=itemView.findViewById(R.id.amount);
            date=itemView.findViewById(R.id.dare);
        }
    }
}
