package com.fryanramzkhar.myfootballclub.UI.Favorite;

import android.content.Context;

import com.fryanramzkhar.myfootballclub.Data.Local.FootballDatabase;
import com.fryanramzkhar.myfootballclub.Model.TeamsItem;

import java.util.ArrayList;
import java.util.List;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailureMessage("Tidak ada data di Favorite");
        }

        view.hideRefresh();
    }

    @Override
    public void searchTeams(Context context, String searchText) {
        if (!searchText.isEmpty()){
            footballDatabase = FootballDatabase.getFootballDatabase(context);
            // Memasukkan semua Data Favorite ke dalam Variable List
            List<TeamsItem> teamsItemList = footballDatabase.footballDao().selectFavorite();
            //Membuat penampung untuk menampung data yang sudah kita seleksi berdasarkan inputan user
            List<TeamsItem> mTeamsItemList = new ArrayList<>();

            //Mencek apakah penampung 1 ada isinya atau tidak
            if (teamsItemList !=null){
                //Melakukan Perulangan sebagai seleksi
                for (TeamsItem data: teamsItemList){
                    // Pengecekan team berdasarkan permitaan user
                    String namaTeam = data.getStrTeam().toLowerCase();
                    if (namaTeam.contains(searchText.toLowerCase())){
                        // Memasukkan team yang sama dengan inputan iser ke dalam wadah data
                        mTeamsItemList.add(data);
                    }
                }
                //Mengirimkan penampung ke-2 ke dalam List
                view.showDataList(mTeamsItemList);
            }
        }else {
            //Apabila Inputan User Kosong, ambil data tanpa keyword
            getDataListTeams(context);
        }
    }
}
