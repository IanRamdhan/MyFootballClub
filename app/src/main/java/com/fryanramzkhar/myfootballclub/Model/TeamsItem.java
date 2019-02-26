package com.fryanramzkhar.myfootballclub.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//TODO Mengimplement ke Seriazable
@Entity(tableName = "teams")
public class TeamsItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String strTeam;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    //TODO Membuat Constractor

    public TeamsItem(String idTeam, String strTeam, String strTeamBadge, String strDescriptionEN) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBadge;
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDetailTeam) {
        this.strDescriptionEN = strDetailTeam;
    }
}
