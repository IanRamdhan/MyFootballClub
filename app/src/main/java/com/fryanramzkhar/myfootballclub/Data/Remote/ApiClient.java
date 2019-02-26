package com.fryanramzkhar.myfootballclub.Data.Remote;

import com.fryanramzkhar.myfootballclub.Utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//TODO 1 Mengambil URL agar dapat mengambil data dari internet

public class ApiClient {
    public static Retrofit retrofit = null;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
