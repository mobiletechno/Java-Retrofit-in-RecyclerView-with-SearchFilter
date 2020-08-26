
package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee;


import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeDBResponse {


    @SerializedName(Constant.API_PARAM_STATUS)
    @Expose
    private String status;
    @SerializedName(Constant.API_PARAM_DATA)
    @Expose
    private List<Employee> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

}
