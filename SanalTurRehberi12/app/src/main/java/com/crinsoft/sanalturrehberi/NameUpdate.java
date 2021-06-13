package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NameUpdate extends AppCompatActivity {
    EditText editText;
    Button button;
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String UserNickName=" ";
    String UpdateTuru=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        UserNickName =  getIntent().getStringExtra("UserNickName");
        UpdateTuru = getIntent().getStringExtra("UpdateTuru");
        System.out.println("UpdateTuru= "+"  " + UpdateTuru);
        System.out.println("UsernickName="+UserNickName);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_update);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.GuncelleUserName);





        if (UpdateTuru.equals("IsimGuncelleme")){
            editText.setHint("Isim");

        }
        else if(UpdateTuru.equals("SoyisimGuncelleme")){
            editText.setHint("Soyisim");

        }
        else if(UpdateTuru.equals("MailGuncelleme")){
            editText.setHint("Mail Adresi");
        }
        else if(UpdateTuru.equals("UserNickNameGuncelleme")){
            editText.setHint("Kullanıcı Adı");
        }
        else if(UpdateTuru.equals("UserNickNameGuncelleme")){
            editText.setHint("Kullanıcı Adı");
        }

        else if(UpdateTuru.equals("UserPasswordGuncelleme")){
            editText.setHint("Şifre");
        }
        else {

            System.out.println("UPDATE TURU GELMEDİ");
        }







    }
    public void IsimGuncelle1(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



        Call<KullaniciBilgileri> call =jsonPlaceHolderApi.GuncelleIsim(UserNickName,editText.getText().toString());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("BAŞARILIIII");

            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("ONFAILURE");



            }
        });








    }
    public void IsimGuncelle(View view){

        if (UpdateTuru.equals("IsimGuncelleme")){

            IsimGuncelle1();

        }

        else if(UpdateTuru.equals("SoyisimGuncelleme")){

            SoyisimUpdateAPI();



        }
        else if(UpdateTuru.equals("MailGuncelleme")){

            MailUpdateAPI();




        }

        else if(UpdateTuru.equals("UserNickNameGuncelleme")){

            UserNickNameAPI();




        }
        else if(UpdateTuru.equals("UserPasswordGuncelleme")){

            UserPasswordAPI();




        }
        Intent intent = new Intent(getApplicationContext(),FeedSayfasi.class);
        startActivity(intent);



        }



      public void SoyisimUpdateAPI(){
          Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl("http://10.0.2.2/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
          jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

          Call<KullaniciBilgileri> call =jsonPlaceHolderApi.guncelleSoyisim(UserNickName,editText.getText().toString());
          call.enqueue(new Callback<KullaniciBilgileri>() {
              @Override
              public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                  System.out.println("BAŞARILIIII");
              }

              @Override
              public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                  System.out.println("Onfailure");
              }
          });

      }

    public void MailUpdateAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<KullaniciBilgileri> call =jsonPlaceHolderApi.guncelleMailAdresi(UserNickName,editText.getText().toString());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("BAŞARILIIII");
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("Onfailure");
            }
        });
    }
    public void UserNickNameAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<KullaniciBilgileri> call =jsonPlaceHolderApi.guncelleKullaniciAdi(UserNickName,editText.getText().toString());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("BAŞARILIIII");
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("Onfailure");
            }
        });

    }
    public void UserPasswordAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<KullaniciBilgileri> call =jsonPlaceHolderApi.guncelleSifre(UserNickName,editText.getText().toString());
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("BAŞARILIIII");
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("Onfailure");
            }
        });

    }











    }





