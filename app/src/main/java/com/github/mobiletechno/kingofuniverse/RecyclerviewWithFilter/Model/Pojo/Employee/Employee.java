
package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {


    @SerializedName(Constant.API_PARAM_ID)
    @Expose
    private String id;
    @SerializedName(Constant.API_PARAM_EMPLOYEE_NAME)
    @Expose
    private String employeeName;
    @SerializedName(Constant.API_PARAM_EMPLOYEE_SALARY)
    @Expose
    private String employeeSalary;
    @SerializedName(Constant.API_PARAM_EMPLOYEE_AGE)
    @Expose
    private String employeeAge;
    @SerializedName(Constant.API_PARAM_EMPLOYEE_IMAGE)
    @Expose
    private String profileImage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

}