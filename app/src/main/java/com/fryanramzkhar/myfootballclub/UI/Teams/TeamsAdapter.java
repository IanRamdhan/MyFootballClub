package com.fryanramzkhar.myfootballclub.UI.Teams;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fryanramzkhar.myfootballclub.Model.TeamsItem;
import com.fryanramzkhar.myfootballclub.R;
import com.fryanramzkhar.myfootballclub.UI.Detail.DetailActivity;
import com.fryanramzkhar.myfootballclub.Utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    //TODO 3 Mengatur Adapter

    private Context context;
    private List<TeamsItem> teamsItemList;

    public TeamsAdapter(Context context, List<TeamsItem> teamsItemList) {
        this.context = context;
        this.teamsItemList = teamsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TeamsItem teamsItem = teamsItemList.get(i);

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken).placeholder(R.drawable.ic_broken);
        Glide.with(context).load(teamsItem.getStrTeamBadge()).apply(options).into(viewHolder.imgLogoTeam);
        viewHolder.txtNameTeam.setText(teamsItem.getStrTeam());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class).putExtra(Constant.KEY_DATA,teamsItem));
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
