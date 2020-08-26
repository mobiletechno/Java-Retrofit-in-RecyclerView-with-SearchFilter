package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Repository;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.DataSource.EmployeeDataService;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.DataSource.RetrofitClient;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.Employee;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.EmployeeDBResponse;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.View.MainActivity.mytoast;
import static com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.View.MainActivity.progress;


public class EmployeeRepository {

    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<ArrayList<Employee>> mutableLiveData = new MutableLiveData<>();
    Activity context;


    public EmployeeRepository(ArrayList<Employee> employees, MutableLiveData<ArrayList<Employee>> mutableLiveData) {
        this.employees = employees;
        this.mutableLiveData = mutableLiveData;

    }


    public MutableLiveData<ArrayList<Employee>> getMutableLiveData() {

        final EmployeeDataService userDataService = RetrofitClient.getService();

        Call<EmployeeDBResponse> call = userDataService.getEmployees();
        call.enqueue(new Callback<EmployeeDBResponse>() {

            @Override
            public void onResponse(Call<EmployeeDBResponse> call, Response<EmployeeDBResponse> response) {
                progress.dismiss();
                EmployeeDBResponse employeeDBResponse = response.body();
                if (employeeDBResponse != null && employeeDBResponse.getData() != null) {
                    employees = (ArrayList<Employee>) employeeDBResponse.getData();
                    mutableLiveData.setValue(employees);
                }
            }

            @Override
            public void onFailure(Call<EmployeeDBResponse> call, Throwable t) {
                mytoast.show();
                progress.dismiss();
            }
        });
        return mutableLiveData;
    }
}
