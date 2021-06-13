package com.crinsoft.sanalturrehberi;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("WebAPIForTrip/api/user/{UserId}")
    Call<List<KullaniciBilgileri>> getUserId(@Path("UserId") int UserId);

    @GET("WebAPIForTrip/api/user/ByUserNameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserName(@Query("UserName") String UserName);

    @GET("WebAPIForTrip/api/user/ByuserSurnameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getSurname(@Query("UserSurname") String UserSurName);


    @GET("WebAPIForTrip/api/user/ByUserMailAdressKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getMailAdress(@Query("UserMailAdress") String UserMailAdress);

    @GET("WebAPIForTrip/api/user/ByUserNickNameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserNickName(@Query("UserNickName") String UserNickName);


    @GET("WebAPIForTrip/api/user/ByUserPasswordKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserPassword(@Query("UserPassword") String UserPassword);

    @GET("WebAPIForTrip/api/user/ByUserAgainPassword")
    Call<List<KullaniciBilgileri>> getUserAgainPassword(@Query("UserAgainPassword") String UserAgainPassword);

    @GET("WebAPIForTrip/api/user/SehirAdlari")
    Call<List<KullaniciBilgileri>> SehirAdlari();

    @GET("WebAPIForTrip/api/user/HavaDurumu")
    Call<List<KullaniciBilgileri>> HavaDurumu();

    @GET("WebAPIForTrip/api/user/SifremiUnuttum")
    Call<List<KullaniciBilgileri>> SifremiUnuttum(@Query("UserName")String UserName,@Query("UserSurname") String UserSurname,@Query("UserMailAdress") String UserMailAdress );






    @GET("WebAPIForTrip/api/user/ByTurIsmi")
    Call<List<KullaniciBilgileri>> getTurName(@Query("Turİsmi") String TurIsmi);

    @GET("WebAPIForTrip/api/user/TurBilgileri")
    Call<List<KullaniciBilgileri>> getTurlar();

    @GET("WebAPIForTrip/api/user/TurBilgileriDiscent")
    Call<List<KullaniciBilgileri>> getTurIsimleri();


    @GET("WebAPIForTrip/api/user/MekanBilgileri")
    Call<List<KullaniciBilgileri>> getMekanBilgileri(@Query("TurIsmi") String TurIsmi  );

    @GET("WebAPIForTrip/api/user/MekanAciklamasi")
    Call<List<KullaniciBilgileri>> getMekanAciklamasi(@Query("MekanIsimleri") String MekanAciklamalari  );

    @GET("WebAPIForTrip/api/user/KordinatGetir")
    Call<List<KullaniciBilgileri>> getKordinat(@Query("MekanIsimleri") String MekanIsmi  );

    @GET("WebAPIForTrip/api/user/MekanFoto")
    Call<List<KullaniciBilgileri>> getPhotos(@Query("MekanIsimleri") String MekanIsmi  );

    @GET("WebAPIForTrip/api/user/FavlariGetir")
    Call<List<KullaniciBilgileri>> FavlariGetir(@Query("UserNickName") String UserNickName  );


    @GET("WebAPIForTrip/api/user/getNotlar")
    Call<List<KullaniciBilgileri>> getNotlar(@Query("UserNickName") String UserNickName);

    @GET("WebAPIForTrip/api/user/GidilenMekanGetir")
    Call<List<KullaniciBilgileri>> GidilenMekanGetir(@Query("UserNickName") String UserNickName);

    @GET("WebAPIForTrip/api/user/TercihEdilenMekanGetir")
    Call<List<KullaniciBilgileri>> TercihEdilenMekanGetir();


    @GET("WebAPIForTrip/api/user/YorumGetir")
    Call<List<KullaniciBilgileri>> YorumGetir(@Query("UserNickName") String UserNickName);








    @POST("WebAPIForTrip/api/user/KayitOl")
   Call<KullaniciBilgileri> createPost(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/FavEkle")
    Call<KullaniciBilgileri> FavEkle(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/YorumYap")
    Call<KullaniciBilgileri> YorumYap(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/NotlarKaydet")
    Call<KullaniciBilgileri> NotlarKaydet(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/GidilenMekanlaraEkle")
    Call<KullaniciBilgileri> GidilenMekanlaraEkle(@Body KullaniciBilgileri kullaniciBilgileri);




    //KullaniciBilgileriniGuncelleme

    @PUT("WebAPIForTrip/api/user/GuncelleIsim")
    Call<KullaniciBilgileri> GuncelleIsim(@Query("UserNickName") String UserNickName,@Query("UserName") String userName);

    @PUT("WebAPIForTrip/api/user/GuncelleSurname")
    Call<KullaniciBilgileri> guncelleSoyisim(@Query("UserNickName") String UserNickName,@Query("UserSurname") String UserSurname);

    @PUT("WebAPIForTrip/api/user/GuncelleMailAdresi")
    Call<KullaniciBilgileri> guncelleMailAdresi(@Query("UserNickName") String UserNickName,@Query("UserMailAdress") String MailAdress);

    @PUT("WebAPIForTrip/api/user/GuncelleKullaniciAdi")
    Call<KullaniciBilgileri> guncelleKullaniciAdi(@Query("UserNickName") String UserNickName,@Query("UserNickName") String UserNickName1);

    @PUT("WebAPIForTrip/api/user/GuncelleSifre")
    Call<KullaniciBilgileri> guncelleSifre(@Query("UserNickName") String UserNickName,@Query("UserPassword") String UserPassword);




    @DELETE("WebAPIForTrip/api/user/FavSil")
    Call<KullaniciBilgileri> FavSil(@Query("UserNickName") String UserNickName,@Query("MekanIsimleri") String MekanIsmi);

    @DELETE("WebAPIForTrip/api/user/YorumSil")
    Call<KullaniciBilgileri> YorumSil(@Query("UserNickName") String UserNickName,@Query("MekanYorumu") String mekanYorumu);





}
