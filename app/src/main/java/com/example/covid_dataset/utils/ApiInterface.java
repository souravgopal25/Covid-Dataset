package com.example.covid_dataset.utils;

import com.example.covid_dataset.model.Data;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @GET("/data.json")
    Call<Data> getList();

}
