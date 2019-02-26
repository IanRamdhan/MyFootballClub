package com.fryanramzkhar.myfootballclub.UI.Teams;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.fryanramzkhar.myfootballclub.Model.TeamsItem;
import com.fryanramzkhar.myfootballclub.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends Fragment implements TeamsContract.View {

    //TODO 2 Search di Butterknife

    @BindView(R.id.rv_teams)
    RecyclerView rvTeams;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.btnSearch)
    ImageButton btnSearch;
    //TODO Membuat Variable yang dibutuhkan
    private ProgressDialog progressDialog;
    private TeamsPresenter teamsPresenter = new TeamsPresenter(this);

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TODO JANGAN MEMBUAT PERINTAH DI BAWAH RETURN VIEW
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        unbinder = ButterKnife.bind(this, view);

        //Mengambil Data dari Presenter
        teamsPresenter.getDataListTeams();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                teamsPresenter.getDataListTeams();
            }
        });
        //TODO 3 Mengatur ketika button search di klik
        setupUIListener();
        return view;
    }

    private void setupUIListener() {
        //TODO 5 Mengatur bahan yang diperlukan
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mengambil Inputan User yang ada di dalam editText
                String searchText = edtSearch.getText().toString().toLowerCase();
                // Mengirimkn Inoutan User ke Presenter untuk di Request ke API
                teamsPresenter.getSearchTeam(searchText);
            }
        });
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        //Mengatur RecycleView
        rvTeams.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTeams.setAdapter(new TeamsAdapter(getContext(), teamsItemList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
