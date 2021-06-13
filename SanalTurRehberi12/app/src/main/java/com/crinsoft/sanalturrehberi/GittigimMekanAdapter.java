package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GittigimMekanAdapter extends RecyclerView.Adapter<GittigimMekanAdapter.GittigimViewHolder> {
    private ArrayList<GittigimMekanBilgileri> mList = new ArrayList<>();



    public GittigimMekanAdapter(ArrayList<GittigimMekanBilgileri> mList){
        this.mList = mList;


    }


    @NonNull
    @Override
    public GittigimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gittigim_turlar_main, parent, false);
        return  new GittigimViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GittigimMekanAdapter.GittigimViewHolder holder, int position) {
        holder.GittigimMekanIsmi.setText(mList.get(position).getGidilenMekan());

    }

    @Override
    public int getItemCount() {
        return  mList.size();
    }

    public class GittigimViewHolder extends RecyclerView.ViewHolder {
        TextView GittigimMekanIsmi;


        public GittigimViewHolder(@NonNull View itemView) {
            super(itemView);
            GittigimMekanIsmi=itemView.findViewById(R.id.GittigimMekanIsmi);


        }
    }
}
