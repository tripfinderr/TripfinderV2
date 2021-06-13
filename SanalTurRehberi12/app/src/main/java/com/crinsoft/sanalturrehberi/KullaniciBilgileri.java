package com.crinsoft.sanalturrehberi;

import com.google.gson.annotations.SerializedName;

public class KullaniciBilgileri {
    //Kullanici Bilgileri
    @SerializedName("UserId")
    private int KullaniciID;
    @SerializedName("UserName")
    private String Isim;
    @SerializedName("UserSurname")
    private String UserSurname;
    @SerializedName("UserMailAdress")
    private String userMailAdress;
    @SerializedName("UserNickName")
    private String UserNickName;
    @SerializedName("UserPassword")
    private String UserPassword;
    @SerializedName("UserAgainPassword")
    private String UserAgainPassword;

    //TurBilgileri
    @SerializedName("Turİsmi")
    private String TurIsmi;

    @SerializedName("MekanIsimleri")
    private String MekanIsimleri;

    @SerializedName("Kordinatlar")
    private String Kordinatlar;


    @SerializedName("MekanAciklamalari")
    private String MekanAciklamalari;

    @SerializedName("Favori")
    private String Favori;

    @SerializedName("MekanYorumu")
    private String MekanYorumu;

    @SerializedName("MekanFotoURL")
    private String MekanFotoURL;

    @SerializedName("Sehirler")
    private String Sehirler;

    @SerializedName("SehirDurumu")
    private String SehirDurumu;

    @SerializedName("Notlar")
    private String Notlar;

    @SerializedName("Sehir")
    private String Sehir;

    @SerializedName("Ilce")
    private String Ilce;

    @SerializedName("CDerece")
    private String CDerece;

    @SerializedName("NotBasligi")
    private String NotBasligi;

    @SerializedName("GidilenMekan")
    private String GidilenMekan;


    @SerializedName("Occurrences")
    private String Occurrences;




    public String getOccurrences() {
        return Occurrences;
    }

    public String getGidilenMekan() {
        return GidilenMekan;
    }

    public String getNotBasligi() {
        return NotBasligi;
    }

    public String getSehir() {
        return Sehir;
    }

    public String getIlce() {
        return Ilce;
    }

    public String getCDerece() {
        return CDerece;
    }

    public String getNotlar() {
        return Notlar;
    }

    public String getSehirler() {
        return Sehirler;
    }

    public String getSehirDurumu() {
        return SehirDurumu;
    }

    public String getMekanFotoURL() {
        return MekanFotoURL;
    }

    public String getMekanYorumu() {
        return MekanYorumu;
    }
    public String getFavori() {
        return Favori;
    }
    public String getMekanAciklamalari() {
        return MekanAciklamalari;
    }

    public String getTurIsmi() {
        return TurIsmi;
    }

    public String getMekanIsimleri() {
        return MekanIsimleri;
    }

    public String getKordinatlar() {
        return Kordinatlar;
    }

    public int getKullaniciID() {
        return KullaniciID;
    }

    public String getIsim() {
        return Isim;
    }

    public String getUserSurname() {
        return UserSurname;
    }

    public String getUserMailAdress() {
        return userMailAdress;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public String getUserAgainPassword() {
        return UserAgainPassword;
    }



    public KullaniciBilgileri(String isim, String userSurname, String userMailAdress, String userNickName, String userPassword, String userAgainPassword,String TurIsmi,String MekanIsimleri,String Kordinatlar,String MekanAciklamalari,String Favori,String MekanYorumu,String MekanFotoURL,String Sehirler,String SehirDurumu,String Notlar,String Sehir,String Ilce,String CDerece,String NotBasligi,String GidilenMekan,String Occurrences ) {
        this.Isim = isim;
        this.UserSurname = userSurname;
        this.userMailAdress = userMailAdress;
        this.UserNickName = userNickName;
        this.UserPassword = userPassword;
        this.UserAgainPassword = userAgainPassword;
        this.TurIsmi = TurIsmi;
        this.MekanIsimleri = MekanIsimleri;
        this.Kordinatlar = Kordinatlar;
        this.MekanAciklamalari=MekanAciklamalari;
        this.Favori=Favori;
        this.MekanYorumu=MekanYorumu;
        this.MekanFotoURL = MekanFotoURL;
        this.Sehirler=Sehirler;
        this.SehirDurumu=SehirDurumu;
        this.Notlar=Notlar;
        this.Sehir=Sehir;
        this.Ilce=Ilce;
        this.CDerece=CDerece;
        this.NotBasligi=NotBasligi;
        this.GidilenMekan=GidilenMekan;
        this.Occurrences = Occurrences;
    }
}
