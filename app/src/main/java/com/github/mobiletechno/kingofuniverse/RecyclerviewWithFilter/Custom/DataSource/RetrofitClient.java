package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.DataSource;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    private static final String BASE_URL = Constant.BASE_URL;

    public static EmployeeDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(EmployeeDataService.class);
    }
}