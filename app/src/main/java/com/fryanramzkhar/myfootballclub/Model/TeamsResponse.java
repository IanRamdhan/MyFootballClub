package com.fryanramzkhar.myfootballclub.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Query;

public class TeamsResponse {

    @SerializedName("teams")
    private List<TeamsItem> teams;

    public List<TeamsItem> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }
}
