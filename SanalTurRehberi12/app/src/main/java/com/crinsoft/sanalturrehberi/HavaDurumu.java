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

public class HavaDurumu extends AppCompatActivity {

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<HavaDurumuBilgileri> havaDurumuBilgileris;

    RecyclerView recyclerView;
    HavaDurumuAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getHavaDurumuDatas();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hava_durumu);

        havaDurumuBilgileris = new ArrayList<>();

        recyclerView = findViewById(R.id.havaDurumuRecycl);
        recyclerView.setHasFixedSize(true);

        setAdapter();
    }

    public void getHavaDurumuDatas(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.HavaDurumu();
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    post.getSehir();
                    post.getIlce();
                    post.getCDerece();
                    havaDurumuBilgileris.add(new HavaDurumuBilgileri(post.getSehir(),post.getIlce(),post.getCDerece()));





                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });
    }

    public void setAdapter(){
        adapter = new HavaDurumuAdapter(havaDurumuBilgileris);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }
}