package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    private ArrayList<FavBilgileri> mList = new ArrayList<>();
    private Context context;
    private String UserNickName;


    public FavAdapter(ArrayList<FavBilgileri> mList,Context context,String userNickName){
        this.mList = mList;
        this.context = context;
        this.UserNickName = userNickName;



    }


    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favlarigoster_rec, parent, false);
        return  new FavViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.FavViewHolder holder, final int position) {
        holder.favIsmi.setText(mList.get(position).getMekanIsimleri());
        holder.deleteFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFavs(position);
                Toast toast = Toast.makeText(context,"SİLE TIKLADI!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();







            }
        });


    }

    public void deleteFavs(int position){


        JsonPlaceHolderApi jsonPlaceHolderApi;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<KullaniciBilgileri> call = jsonPlaceHolderApi.FavSil(UserNickName,mList.get(position).getMekanIsimleri());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                Toast toast = Toast.makeText(context, "Favori Mekan Silindi!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                Toast toast = Toast.makeText(context, "Favori Mekan Silindi!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        TextView favIsmi;
        ImageView deleteFav;
        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            favIsmi = itemView.findViewById(R.id.mekanIsmiFav);
            deleteFav = itemView.findViewById(R.id.deleteFavImage);


        }
    }
}
