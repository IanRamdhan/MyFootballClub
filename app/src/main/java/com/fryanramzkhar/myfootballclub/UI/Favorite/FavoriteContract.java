package com.fryanramzkhar.myfootballclub.UI.Favorite;

import android.content.Context;

import com.fryanramzkhar.myfootballclub.Model.TeamsItem;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getDataListTeams(Context context);
    }
}
