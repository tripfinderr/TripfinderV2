package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Notlarim extends AppCompatActivity {
    EditText notlarMultiLine;
    CardView kaydetButton;
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String UserNickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlarim);
        kaydetButton = findViewById(R.id.KaydetCardView);
        Intent intent = getIntent();
        UserNickName =  intent.getStringExtra("KullaniciAdi");
    }

    public void Kaydet(){
        notlarMultiLine = findViewById(R.id.notlarMultiLine);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri(null,null,null,UserNickName,null,null,null,null,null,null,null,null,null,null,null,notlarMultiLine.getText().toString(),null,null,null,null,null,null);
            Call<KullaniciBilgileri> call = jsonPlaceHolderApi.NotlarKaydet(kullaniciBilgileri);
            call.enqueue(new Callback<KullaniciBilgileri>() {
                @Override
                public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not Başarı ile Oluşturuldu!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }

                @Override
                public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                    System.out.println(t);
                }
            });

        }

        public void Notkaydet(View view){
            Kaydet();
            Intent intent = new Intent(getApplicationContext(),FeedSayfasi.class);
            startActivity(intent);

        }

}
