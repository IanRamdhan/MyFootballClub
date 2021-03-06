package com.fryanramzkhar.myfootballclub.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.fryanramzkhar.myfootballclub.Model.TeamsItem;

public interface DetailContract {

    interface View{
        void showDetailTeam(TeamsItem teamsItem);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface Presenter{
        void getDetailTeam(Bundle bundle);
        void addToFavorite(Context context, TeamsItem teamsItem);
        void removeFavorite(Context context, TeamsItem teamsItem);
        Boolean checkFavorite(Context context, TeamsItem teamsItem);
    }
}
