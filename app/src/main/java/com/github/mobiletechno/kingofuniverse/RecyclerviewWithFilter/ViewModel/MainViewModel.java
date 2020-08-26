package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.Employee;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Repository.EmployeeRepository;

import java.util.ArrayList;


public class MainViewModel extends ViewModel {


    private EmployeeRepository employeeRepository;
    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<ArrayList<Employee>> mutableLiveData = new MutableLiveData<>();

    public MainViewModel() {
        mutableLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public LiveData<ArrayList<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }

    public MutableLiveData<ArrayList<Employee>> getUserMutableLiveData() {
        return mutableLiveData;
    }

    public void init() {
        employeeRepository = new EmployeeRepository(employees, mutableLiveData);
        getAllEmployee();
        mutableLiveData.setValue(employees);
    }


}
