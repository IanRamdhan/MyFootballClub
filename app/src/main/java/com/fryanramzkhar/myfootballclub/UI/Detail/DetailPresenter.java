package com.fryanramzkhar.myfootballclub.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.fryanramzkhar.myfootballclub.Data.Local.FootballDatabase;
import com.fryanramzkhar.myfootballclub.Model.TeamsItem;
import com.fryanramzkhar.myfootballclub.Utils.Constant;

public class DetailPresenter implements DetailContract.Presenter {

     private final DetailContract.View view;
     private FootballDatabase footballDatabase;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailTeam(Bundle bundle) {
        if (bundle != null){
            TeamsItem teamsItem = (TeamsItem) bundle.getSerializable(Constant.KEY_DATA);
            view.showDetailTeam(teamsItem);
        }else {
            view.showFailureMessage("Data Kosong");
        }
    }

    @Override
    public void addToFavorite(Context context, TeamsItem teamsItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().insertItem(teamsItem);
        view.showSuccessMessage("Tersimpan");
    }

    @Override
    public void removeFavorite(Context context, TeamsItem teamsItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().delete(teamsItem);
        view.showSuccessMessage("Terhapus");
    }

    @Override
    public Boolean checkFavorite(Context context, TeamsItem teamsItem) {
        Boolean bFavorite = false;
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        return bFavorite = footballDatabase.footballDao().selectedItem(teamsItem.getIdTeam()) != null;
    }
}
