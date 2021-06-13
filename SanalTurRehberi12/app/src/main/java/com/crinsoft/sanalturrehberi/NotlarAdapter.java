package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.NotViewHolder> {

    private ArrayList<NotBilgileri> mList = new ArrayList<>();


    public NotlarAdapter(ArrayList<NotBilgileri> mList){
        this.mList = mList;

    }

    @NonNull
    @Override
    public NotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notlar_recycler, parent, false);
        return  new NotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotlarAdapter.NotViewHolder holder, int position) {
        holder.baslikTextView.setText(mList.get(position).getNotBasligi());
        holder.Notlar.setText(mList.get(position).getNotlar());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NotViewHolder extends RecyclerView.ViewHolder {

        public TextView baslikTextView;
        public CardView cardView;
        public TextView Notlar;

        public NotViewHolder(@NonNull View itemView) {
            super(itemView);
            baslikTextView=itemView.findViewById(R.id.baslikTextView);
            cardView=itemView.findViewById(R.id.basikCardView);
            Notlar = itemView.findViewById(R.id.notlarMultiLine);


        }
    }
}
