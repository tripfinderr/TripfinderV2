package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YorumlariGor extends AppCompatActivity {
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<YorumBilgileri> yorumBilgileris;

    RecyclerView recyclerView;
    YorumAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    String UserNickName=" ";
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context =getApplicationContext();
        Intent intent = getIntent();
        UserNickName = intent.getStringExtra("UserNickName");
        yorumBilgileris = new ArrayList<>();
        getYorumDatas();
        //yorumBilgileris.add(new YorumBilgileri("ok12","AAAA","aaaa","aaaaa"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorumlari_gor);


        recyclerView = findViewById(R.id.YorumlariGorRec);
        recyclerView.setHasFixedSize(true);
        setAdapter();

    }


     public void  getYorumDatas(){
         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("http://10.0.2.2/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
         Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.YorumGetir(UserNickName);
         call.enqueue(new Callback<List<KullaniciBilgileri>>() {
             @Override
             public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                 List<KullaniciBilgileri> posts = response.body();
                 for(KullaniciBilgileri post : posts){

                     yorumBilgileris.add(new YorumBilgileri(post.getUserNickName(),null,post.getMekanIsimleri(),post.getMekanYorumu()));
                     System.out.println("DENEME"+post.getUserNickName()+post.getMekanIsimleri()+post.getMekanYorumu());





                 }

             }

             @Override
             public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

             }
         });


     }
    public void setAdapter(){
        adapter = new YorumAdapter(yorumBilgileris,context,UserNickName);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }




}