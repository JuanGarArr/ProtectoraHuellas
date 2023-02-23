package com.iesam.Protectora.app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dam.sitehub.es/projects/huellas/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ApiService apiService = retrofit.create(ApiService.class);
}
