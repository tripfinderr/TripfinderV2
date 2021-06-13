package com.crinsoft.sanalturrehberi;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SehirAramaTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SehirAramaTab extends Fragment {
    private View view;
    private AutoCompleteTextView autoCompleteTextView;
    private CardView cardView;
    private ArrayList<String> Sehirler = new ArrayList<>();
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SehirAramaTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SehirAramaTab.
     */
    // TODO: Rename and change types and number of parameters
    public static SehirAramaTab newInstance(String param1, String param2) {
        SehirAramaTab fragment = new SehirAramaTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SehirGetirFromAPI();
        view =inflater.inflate(R.layout.fragment_sehir_arama_tab, container, false);
        autoCompleteTextView = view.findViewById(R.id.sehirAuto);
        cardView = view.findViewById(R.id.cardView5);

        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line, Sehirler);
        autoCompleteTextView.setAdapter(arrayAdapter);

        return view;
    }

    public void SehirGetirFromAPI(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.SehirAdlari();
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){

                    Sehirler.add(post.getSehirler());






                }

            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });



    }
}