package com.crinsoft.sanalturrehberi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedSayfasi extends AppCompatActivity {
    CardView EnCokTercihEdilenTurlarCardView;
    BottomNavigationView mMainNav;
    Toolbar layoutToolBar1;
    FrameLayout frameLayout;
    HomeTab homeTab;
    SehirAramaTab sehirAramaTab;
    FavorilerTab favorilerTab;
    HesabimTab hesabimTab;
    TextView textView7;
    CardView YorumlariGor;
    CardView EnCokTercihEdilenTurlar;



    TextView deneme;
    String UserNickName=" ";
    TextView textView3;

    public String getUserNickName() {
        return UserNickName;
    }

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    ArrayList<String> Sehirler = new ArrayList<>();
    ArrayList<String> Sehirler2 = new ArrayList<>();

    CardView FavlariGor;

       View view;
    NavigationView navigationView;


    AutoCompleteTextView sehirAutoCTextView;

    RecyclerView recyclerView;
    //FavRecyclerView adapter;
    RecyclerView.LayoutManager mLayoutManager;

    TextView textView8;
    TextView textView11;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        homeTab = new HomeTab();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_sayfasi);
        setFragment(homeTab);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer((GravityCompat.START));
            }
        });
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        mMainNav = (BottomNavigationView) findViewById(R.id.bottomNavigationView );
        deneme = findViewById(R.id.deneme);


        Intent inten = new Intent(FeedSayfasi.this,MainActivity.class);
        UserNickName = getIntent().getStringExtra("KullaniciAdi");
        System.out.println(UserNickName);
        deneme.setText("Gelen bilgi"+ UserNickName);

        textView8 = findViewById(R.id.textView8);
        textView11=findViewById(R.id.textView11);



        FavlariGor = findViewById(R.id.FavlariGor);
        textView7=findViewById(R.id.textView7);


        EnCokTercihEdilenTurlarCardView = findViewById(R.id.EnCokTercihEdilenTurlar);
        YorumlariGor=findViewById(R.id.YorumlariGor);


        EnCokTercihEdilenTurlar = findViewById(R.id.EnCokTercihEdilenTurlar);




        sehirAramaTab = new SehirAramaTab();
        favorilerTab = new FavorilerTab();
        hesabimTab = new HesabimTab();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.HomeTab :
                        setFragment(homeTab);
                        return true;

                    case R.id.sehirAramaTab :
                        setFragment(sehirAramaTab);
                        System.out.println("Sehirler"+Sehirler);

                        return true;

                    case R.id.favorilerTab :
                        setFragment(favorilerTab);
                        return true;

                    case R.id.persontab :
                        setFragment(hesabimTab);
                        textView3 = findViewById(R.id.textView3);


                        return true;

                    default:
                       return false;

                }


            }
        });

        navigationView = findViewById(R.id.toolbarmenu);


    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.AnaSayfa:
                    setFragment(homeTab);
                    return true;
                case R.id.Gittiklerim:
                    Intent intentGittiklerim = new Intent(getApplicationContext(),GittigimTurlar.class);
                    UserNickName = getIntent().getStringExtra("KullaniciAdi");
                    intentGittiklerim.putExtra("UserNickName",UserNickName);
                    startActivity(intentGittiklerim);
                    return true;
                case R.id.Destek:
                    System.out.println("Destek");
                    return true;
                case R.id.Hakkımızda:
                    System.out.println("Hakkımızda");
                    return true;
                case R.id.SıkcaSorulanSorular:
                   Intent intentSSS = new Intent(getApplicationContext(),SSSorular.class);
                   startActivity(intentSSS);
                    return true;
                case R.id.CikisYap:
                    Intent intentLogOut = new Intent(getApplicationContext(),FeedSayfasi.class);
                    startActivity(intentLogOut);
                    return true;





            }
        return true;
        }
    });










    }




    private void setFragment(Fragment fragment){
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.frameLayout,fragment);
    fragmentTransaction.commit();

    }
    public void HhesapBilgileri(View view){

        Intent intent = new Intent(this,HesapBilgileri.class);
        intent.putExtra("KullaniciAdi", UserNickName);
        startActivity(intent);


    }




    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    public void gotoGoogleMaps(View view){
        Intent intent = new Intent(FeedSayfasi.this,GoogleMapActivity.class);
        startActivity(intent);


    }



    public void SeyehatPlanlari(View view){
        Intent intent = new Intent(FeedSayfasi.this,SeyehatPlanlari.class);
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);


    }

    public void SehirArama(View view){

        sehirAutoCTextView=findViewById(R.id.sehirAuto);
        if(sehirAutoCTextView.getText().toString().equals("istanbul")){
            Intent intent = new Intent(getApplicationContext(),SeyehatPlanlari.class);
            startActivity(intent);

        }
        else {

            Toast toast = Toast.makeText(getApplicationContext(), "Seçtiğiniz Şehirde Henüz Hizmet Veremiyoruz!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }





    }




    public void SeyehatPlanlariHesabimTab(View view){

        Intent intent = new Intent(getApplicationContext(),SeyehatPlanlari.class);
        startActivity(intent);
    }

        public void NotlarımPage(View view){
            Intent intent = new Intent(getApplicationContext(),NotlarBaslikliGoster.class);
            intent.putExtra("KullaniciAdi",UserNickName);
            startActivity(intent);

        }
        public void SSS(View view){

        Intent intent = new Intent(getApplicationContext(),SSSorular.class);
        startActivity(intent);


        }

        public void HavaDurumu(View view){
        Intent intent = new Intent(getApplicationContext(),HavaDurumu.class);
        startActivity(intent);

        }

        public void FavlariGor(View view){
        Intent intent = new Intent(getApplicationContext(),FavlariGoster.class);
        intent.putExtra("KullaniciAdi",UserNickName);
        startActivity(intent);


        }
        public void HesapToFav(View view){
        Intent intent = new Intent(getApplicationContext(),FavlariGoster.class);
        intent.putExtra("KullaniciAdi",UserNickName);
        startActivity(intent);


        }

        public void HesapToHavaDurumu(View view){
        Intent intent = new Intent(getApplicationContext(),HavaDurumu.class);
        startActivity(intent);

        }

    public void gittigimTurlar(View view){
        Intent intent = new Intent(getApplicationContext(),GittigimTurlar.class);
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);


    }

    public void enCokTercihEdilenTurlar(View view){
        Intent intent = new Intent(getApplicationContext(),EnCokTercihEdilenTurlar.class);
        startActivity(intent);



    }

    public void YorumlariGetir(View view){
        Intent intent = new Intent(getApplicationContext(), com.crinsoft.sanalturrehberi.YorumlariGor.class);
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);


    }

   













    }














