package com.fryanramzkhar.myfootballclub.UI.Teams;

import com.fryanramzkhar.myfootballclub.Model.TeamsItem;

import java.util.List;

public interface TeamsContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListTeams();
        //TODO 4 Membuat Func Seacrhnya
        void getSearchTeam(String searchText);
    }
}
