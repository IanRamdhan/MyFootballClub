package com.fryanramzkhar.myfootballclub.Data.Local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.fryanramzkhar.myfootballclub.Model.TeamsItem;

import java.util.List;

import retrofit2.http.DELETE;
@Dao
public interface FootballDao {

    @Insert
    void insertItem(TeamsItem teamsItem);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    TeamsItem selectedItem(String id);

    @Delete
    void delete(TeamsItem teamsItem);

    @Query("SELECT * FROM teams ORDER BY strTeam ASC")
    List<TeamsItem> selectFavorite();
}
