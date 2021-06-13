package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SifreUnuttum extends AppCompatActivity {

    EditText IsimSifre;
    EditText SoyisimSifre;
    EditText MailAdresiSifre;
    TextView sifreText;
    TextView textView16;
    CardView cardView2;
    Button ButtonDeneme;



    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifre_unuttum);

        IsimSifre = findViewById(R.id.IsimSifre);
        SoyisimSifre = findViewById(R.id.SoyisimSifre);
        MailAdresiSifre = findViewById(R.id.MailAdresiSifre);
        sifreText = findViewById(R.id.sifreText);





    }

    public void SifreGetir(View view){
        getPasswordFAPI();

    }
    public void getPasswordFAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.SifremiUnuttum(IsimSifre.getText().toString(),SoyisimSifre.getText().toString(),MailAdresiSifre.getText().toString());
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
        @Override
        public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
            List<KullaniciBilgileri> posts = response.body();
            for(KullaniciBilgileri post : posts){
                System.out.println(post.getUserPassword());
                if(post.getUserPassword().equals(null)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Bilgiler birbiri ile eşleşmiyor, detaylı bilgi için desteğe başvurunuz!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                }
                else {
                    sifreText.setText(post.getUserPassword());
                }

            }
            Toast toast = Toast.makeText(getApplicationContext(), "Şifre Getirildi!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

        @Override
        public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

        }
    });





}









}