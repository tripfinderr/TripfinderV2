package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavorilerTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavorilerTab extends Fragment {

    private static Retrofit retrofit=null;
   private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<FavBilgileri> favBilgileris;
   private RecyclerView recyclerView;
   //private FavAdapter adapter;
   private RecyclerView.LayoutManager mLayoutManager;
   private View view;
   Context context;
   String KullaniciAdi=" ";







    public FavorilerTab() {

    }



    public static FavorilerTab newInstance(String param1, String param2) {
        FavorilerTab fragment = new FavorilerTab();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_favoriler_tab, container, false);



        return view;
    }


    public void getFavoriler(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.FavlariGetir("OK2");
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                   post.getMekanIsimleri();
                    favBilgileris.add(new FavBilgileri("OK2",post.getMekanIsimleri(),"YES"));


                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });


    }





}