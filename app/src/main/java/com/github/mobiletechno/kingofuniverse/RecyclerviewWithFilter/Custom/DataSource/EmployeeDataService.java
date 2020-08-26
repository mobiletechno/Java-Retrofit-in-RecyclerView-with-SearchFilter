package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.DataSource;


import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.EmployeeDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataService {

    @GET(Constant.EMPLOYEE_API)
    Call<EmployeeDBResponse> getEmployees();
}
