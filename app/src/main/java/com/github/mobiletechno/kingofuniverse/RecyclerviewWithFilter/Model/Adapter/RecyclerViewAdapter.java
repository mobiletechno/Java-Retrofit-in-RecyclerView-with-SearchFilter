package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.Employee;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.R;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<Employee> userArrayList;

    public RecyclerViewAdapter(Activity context, ArrayList<Employee> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.employee_list_item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
        Employee user = userArrayList.get(position);
        viewHolder.TV_Employeename.setText(Constant.EMPLOYEE_NAME + user.getEmployeeName());
        viewHolder.TV_employeesalary.setText(Constant.EMPLOYEE_SALARY + user.getEmployeeSalary());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        TextView TV_Employeename;
        TextView TV_employeesalary;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            TV_Employeename = itemView.findViewById(R.id.tvFullName);
            TV_employeesalary = itemView.findViewById(R.id.tvEmail);


        }
    }

    //add filter
    public void filterList(ArrayList<Employee> filteredList) {
        userArrayList = filteredList;
        notifyDataSetChanged();
    }
}
