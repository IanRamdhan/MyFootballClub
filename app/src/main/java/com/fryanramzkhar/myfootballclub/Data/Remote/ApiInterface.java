package com.fryanramzkhar.myfootballclub.Data.Remote;

import com.fryanramzkhar.myfootballclub.Model.TeamsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    //TODO 2 Mengatur End Point

    @GET("api/v1/json/1/search_all_teams.php")
    Call<TeamsResponse> getAllTeams(@Query("s") String s, @Query("c") String c);

}
