package com.deepsingh44.vinayapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Employee> employees;
    DeepListener deepListener;

    public CustomAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    //attatch your view
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    //data binding
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.tname.setText(employee.getName());
        holder.tid.setText(String.valueOf(employee.getId()));
    }

    //total items
    @Override
    public int getItemCount() {
        return employees.size();
    }

    //view holder that contains view object
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tname, tid;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tname = itemView.findViewById(R.id.myname);
            tid = itemView.findViewById(R.id.id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            deepListener.myItemClick(v, getAdapterPosition());
        }
    }

    public void setDeepListener(DeepListener deepListener){
        this.deepListener=deepListener;
    }

    public interface DeepListener {
        void myItemClick(View view, int position);
    }


}
