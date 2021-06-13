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

public class FavlariGoster extends AppCompatActivity {

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    ArrayList<FavBilgileri> favBilgileris;
    Context context;

    String KullaniciAdi="";

    RecyclerView recyclerView;
    FavAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context =getApplicationContext();
        Intent intent = getIntent();
       KullaniciAdi= intent.getStringExtra("KullaniciAdi");
        System.out.println(KullaniciAdi);






        getFavoriler();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favlari_goster);
        favBilgileris = new ArrayList<>();
        recyclerView = findViewById(R.id.favlariGosterRec);
        recyclerView.setHasFixedSize(true);
        setAdapter();

    }
public void setAdapter(){
    adapter = new FavAdapter(favBilgileris,context,KullaniciAdi);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(adapter);


}

    public void getFavoriler(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.FavlariGetir(KullaniciAdi);
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    post.getMekanIsimleri();
                    favBilgileris.add(new FavBilgileri(KullaniciAdi,post.getMekanIsimleri(),"YES"));


                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });


    }
}