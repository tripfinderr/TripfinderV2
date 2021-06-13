package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NotlarBaslikliGoster extends AppCompatActivity {
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    ArrayList<NotBilgileri> notBilgileris;
    String UserNickName="";

    RecyclerView recyclerView;
    NotlarAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        notBilgileris= new ArrayList<>();
        notBilgileris.add(new NotBilgileri("AASDADA","UserNickName","ASDADSAD"));
        System.out.println(notBilgileris.isEmpty());

        //getNotlar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar_baslikli_goster);

        Intent intent = getIntent();
       UserNickName =  intent.getStringExtra("KullaniciAdi");



        notBilgileris = new ArrayList<>();
       recyclerView = findViewById(R.id.notlarRecBaslik);
       recyclerView.setHasFixedSize(true);
       setAdapter();





    }


    public void getNotlar(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getNotlar(UserNickName);
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    notBilgileris.add(new NotBilgileri(post.getNotlar(),UserNickName,post.getNotBasligi()));

                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });

    }

    public void setAdapter(){
        adapter = new NotlarAdapter(notBilgileris);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }



}