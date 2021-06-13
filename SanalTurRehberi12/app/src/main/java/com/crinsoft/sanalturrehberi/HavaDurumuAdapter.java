package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HavaDurumuAdapter extends RecyclerView.Adapter<HavaDurumuAdapter.WeathViewHolder> {
    private ArrayList<HavaDurumuBilgileri> mList = new ArrayList<>();

    public HavaDurumuAdapter(ArrayList<HavaDurumuBilgileri> mList){
        this.mList = mList;

    }



    @NonNull
    @Override
    public WeathViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hava_durumu_recyclerview, parent, false);
        return  new WeathViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeathViewHolder holder, int position) {
        holder.SehirIsmi.setText(mList.get(position).getSehir());
        holder.Derece.setText(mList.get(position).getCDerece());
        holder.IlceIsmi.setText(mList.get(position).getIlce());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class WeathViewHolder extends RecyclerView.ViewHolder {
        public TextView SehirIsmi;
        public CardView cardView;
        public TextView Derece;
        public TextView IlceIsmi;
        public ImageView imageView;


        public WeathViewHolder(@NonNull View itemView) {
            super(itemView);
            SehirIsmi=itemView.findViewById(R.id.SehirIsmi);
            Derece=itemView.findViewById(R.id.Derece);
            IlceIsmi=itemView.findViewById(R.id.IlceIsmi);
            imageView=itemView.findViewById(R.id.havaDurumuImage);


        }
    }
}
