package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GittigimTurlar extends AppCompatActivity {
    RecyclerView recyclerView;
    GittigimMekanAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<GittigimMekanBilgileri> gittigimMekanBilgileris;
    String UserNickName;

    private static Retrofit retrofit = null;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        UserNickName = intent.getStringExtra("UserNickName");
        gittigimMekanBilgileris = new ArrayList<>();
        getgittigimTurlar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gittigim_turlar);

        recyclerView = findViewById(R.id.gittigimTurlarRec);
        recyclerView.setHasFixedSize(true);
        setAdapter();
    }

    public void setAdapter() {
        adapter = new GittigimMekanAdapter(gittigimMekanBilgileris);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    public void getgittigimTurlar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.GidilenMekanGetir(UserNickName);
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for (KullaniciBilgileri post : posts) {


                    System.out.println(post.getUserNickName() + post.getGidilenMekan());
                    gittigimMekanBilgileris.add(new GittigimMekanBilgileri(post.getUserNickName(),post.getGidilenMekan(),"AAA"));


                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });


    }

}