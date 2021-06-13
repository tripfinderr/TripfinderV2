package com.crinsoft.sanalturrehberi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KayitOlActivity extends AppCompatActivity {
    TextView textViewdeneme;
    TextView textViewkullaniciAdi;
    TextView textViewsifre;
    //KayıtOl
    EditText KIsim;
    EditText KSoyisim;
    EditText KMailAdresi;
    EditText KKullaniciAdi;
    EditText KSifre;
    EditText KTekrarSifre;
    String LoginStatus = " ";
    EditText isimLog;
    EditText soyisimLog;
    EditText mailLog;
    EditText kullaniciAdiLog;
    EditText sifreLog;
    EditText sifreTekrarLog;

    private static Retrofit retrofit = null;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);


    }

    public String KayitOlToLoginPage1() {

        KIsim = findViewById(R.id.IsimTextView);
        KSoyisim = findViewById(R.id.SoyisimTextView);
        KKullaniciAdi = findViewById(R.id.KullaniciAdiSorunlu);
        KMailAdresi = findViewById(R.id.MailAdresiTextView);
        KSifre = findViewById(R.id.SifreTextView);
        KTekrarSifre = findViewById(R.id.SifreTekrarTextView);

        isimLog = findViewById(R.id.isimLog);
        soyisimLog = findViewById(R.id.soyisimLog);
        mailLog = findViewById(R.id.mailLog);
        kullaniciAdiLog = findViewById(R.id.kullaniciAdiLog);
        sifreLog = findViewById(R.id.sifreLog);
        sifreTekrarLog = findViewById(R.id.sifreTekrarLog);









        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        KullaniciBilgileri kullaniciBilgileri =
                new KullaniciBilgileri
                        (KIsim.getText().toString(),
                                KSoyisim.getText().toString(),
                                KMailAdresi.getText().toString(),
                                KKullaniciAdi.getText().toString(),
                                KSifre.getText().toString(),
                                KTekrarSifre.getText().toString(),
                                null,
                                null,
                                null, null, null, null, null,null,null,null,null,null,null,null,null,null);




        System.out.println("LENGHT" +KIsim.getText().length());


        if ((KIsim.getText().length() < 3)) {
            KIsim.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı İsmi 2 karakterden fazla olmalıdır!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            isimLog.setText("Kullanıcı İsmi 2 karakterden fazla olmalıdır!");
            isimLog.setEnabled(false);
            isimLog.setVisibility(View.VISIBLE);
            LoginStatus="Basarisiz";
        }


        if ((KSoyisim.getText().length() < 3)) {
            KSoyisim.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Soyisimi 2 karakterden fazla olmalıdır!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            soyisimLog.setText("Kullanıcı Soyisimi 2 karakterden fazla olmalıdır!");
            soyisimLog.setEnabled(false);
            soyisimLog.setVisibility(View.VISIBLE);
            LoginStatus="Basarisiz";


        }
        if ((KMailAdresi.getText().length() < 3) ) {
            KMailAdresi.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Mail Adresi 2 karakterden fazla olmalıdır, veya düzgün mail adresinizi düzgün bir formatta giriniz.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            mailLog.setVisibility(View.VISIBLE);
            mailLog.setEnabled(false);
            mailLog.setText("Kullanıcı Mail Adresi 2 karakterden fazla olmalıdır!");


            LoginStatus="Basarisiz";
        }

        if (!(KMailAdresi.getText().toString().contains("@"))) {
            KMailAdresi.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Mail Adresi 2 karakterden fazla olmalıdır, veya düzgün mail adresinizi düzgün bir formatta giriniz.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            int RedColorValue = Color.parseColor("#FF2400");
            mailLog.setVisibility(View.VISIBLE);
            mailLog.setEnabled(false);
            mailLog.setText("Kullanıcı Mail Adresi düzgün formatta olmalıdır!");

            LoginStatus="Basarisiz";
        }



        if ((KSifre.getText().length() < 3)) {
            KSifre.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Şifresi 2 karakterden fazla olmalıdır!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            sifreLog.setVisibility(View.VISIBLE);
            sifreLog.setEnabled(false);
            sifreLog.setText("Kullanıcı Mail Adresi düzgün formatta olmalıdır!");

            LoginStatus="Basarisiz";


        }


        if ((KTekrarSifre.getText().length() < 3)) {
            KTekrarSifre.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Şifresi 2 karakterden fazla olmalıdır!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            LoginStatus="Basarisiz";


        }

        if (!(KTekrarSifre.getText().toString().equals(KSifre.getText().toString()))) {
            KTekrarSifre.getText().clear();
            Toast toast = Toast.makeText(getApplicationContext(), "Şifre ile Tekrar Şifre aynı değil!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
           sifreLog.setEnabled(false);
           sifreLog.setVisibility(View.VISIBLE);
           sifreTekrarLog.setVisibility(View.VISIBLE);
            sifreLog.setText("Şifre ile Tekrar Şifre aynı değil!");
            sifreTekrarLog.setText("Şifre ile Tekrar Şifre aynı değil!");

            LoginStatus="Basarisiz";


        }

        else if(LoginStatus.equals(" ")) {
            LoginStatus = "Basarili";
            Call<KullaniciBilgileri> call = jsonPlaceHolderApi.createPost(kullaniciBilgileri);

            call.enqueue(new Callback<KullaniciBilgileri>() {
                @Override
                public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {


                    Toast toast = Toast.makeText(getApplicationContext(), "Başarılı bir şekilde kullanıcı oluşturuldu!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();


                }

                @Override
                public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Başarılı bir şekilde kullanıcı OluşturulduOnfailure!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                }
            });

        }
        return LoginStatus;
    }


    public void KayitOlToLoginPage(View view) {
        System.out.println(KayitOlToLoginPage1());
        if (KayitOlToLoginPage1().equals("Basarili")) {


            Intent intent = new Intent(KayitOlActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Basarili gelmedi!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();




        }


    }

}






