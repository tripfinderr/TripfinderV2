package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EnCokTercihEdilenTurlar extends AppCompatActivity {

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<GittigimMekanBilgileri> gittigimMekanBilgileris;
    private ArrayList<String> EnCokGidilenMekanlar;

    RecyclerView recyclerView;
    TercihAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gittigimMekanBilgileris = new ArrayList<>();
        getTercihEdilenMekanlar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en_cok_tercih_edilen_turlar);


        recyclerView = findViewById(R.id.EnCokTercihRec);
        recyclerView.setHasFixedSize(true);
        setAdapter();
    }


    public void setAdapter(){
        adapter = new TercihAdapter(gittigimMekanBilgileris);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    public void getTercihEdilenMekanlar(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.TercihEdilenMekanGetir();
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    System.out.println( "Deneme"+ post.getUserNickName() +" " +  post.getGidilenMekan());
                    gittigimMekanBilgileris.add(new GittigimMekanBilgileri(null,post.getGidilenMekan(),post.getOccurrences()+" "+"Kullanıcı Tarafından Tercih Edildi"));










                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });
    }




}