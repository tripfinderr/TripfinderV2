package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TercihAdapter extends RecyclerView.Adapter<TercihAdapter.TercihViewHolder>   {
    private ArrayList<GittigimMekanBilgileri> mList = new ArrayList<>();


    public TercihAdapter(ArrayList<GittigimMekanBilgileri> mList){

        this.mList = mList;
    }

    @NonNull
    @Override
    public TercihViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.en_cok_tercih_main, parent, false);
        return  new TercihViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TercihAdapter.TercihViewHolder holder, int position) {
        holder.TercihIsim.setText(mList.get(position).getGidilenMekan());
        holder.adetTercih.setText(mList.get(position).getOccurrences());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TercihViewHolder extends RecyclerView.ViewHolder {
        TextView TercihIsim;
        TextView adetTercih;
        public TercihViewHolder(@NonNull View itemView) {
            super(itemView);
            TercihIsim = itemView.findViewById(R.id.TercihIsim);
            adetTercih=itemView.findViewById(R.id.adetTercih);
        }
    }
}
