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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YorumAdapter extends RecyclerView.Adapter<YorumAdapter.YorumViewHolder> {
    private ArrayList<YorumBilgileri> mList = new ArrayList<>();
    private  Context context;
    private  String UserNickName;



    public YorumAdapter(ArrayList<YorumBilgileri> mList,Context context,String userNickName){
        this.mList = mList;
        this.context=context;
        this.UserNickName=userNickName;
    }



    @NonNull
    @Override
    public YorumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.yorumlari_gor_main, parent, false);
        return  new YorumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull YorumAdapter.YorumViewHolder holder, final int position) {
    holder.YorumMekanIsmi.setText(mList.get(position).getMekanIsimleri());
    holder.YorumIsimText.setText(mList.get(position).getMekanYorumu());

    holder.YorumSilImageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            yorumSilAPI(position);

            Toast toast = Toast.makeText(context, "Başarılı bir şekilde yorum silindi!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

        }
    });

    }

    public void yorumSilAPI(int position){
        JsonPlaceHolderApi jsonPlaceHolderApi;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<KullaniciBilgileri> call = jsonPlaceHolderApi.YorumSil(UserNickName,mList.get(position).getMekanYorumu());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                Toast toast = Toast.makeText(context, "Başarılı bir şekilde yorum silindi!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                Toast toast = Toast.makeText(context, "Başarılı bir şekilde yorum silindi!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });


    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class YorumViewHolder extends RecyclerView.ViewHolder {
        TextView YorumMekanIsmi;
        TextView YorumIsimText;
        ImageView YorumSilImageView;


        public YorumViewHolder(@NonNull View itemView) {
            super(itemView);
          YorumMekanIsmi=  itemView.findViewById(R.id.YorumMekanIsmi);
           YorumIsimText = itemView.findViewById(R.id.YorumIsimText);
           YorumSilImageView = itemView.findViewById(R.id.yorumSilImageView);



        }
    }
}
