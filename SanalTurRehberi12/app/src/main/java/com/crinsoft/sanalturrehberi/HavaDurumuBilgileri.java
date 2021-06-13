package com.crinsoft.sanalturrehberi;

public class HavaDurumuBilgileri {

    private String Sehir;
    private String Ilce;
    public String CDerece;

    public String getSehir() {
        return Sehir;
    }

    public String getIlce() {
        return Ilce;
    }

    public String getCDerece() {
        return CDerece;

    }

    public void setSehir(String sehir) {
        Sehir = sehir;
    }

    public void setIlce(String ilce) {
        Ilce = ilce;
    }

    public void setCDerece(String CDerece) {
        this.CDerece = CDerece;
    }

    public HavaDurumuBilgileri(String sehir, String ilce, String CDerece) {
        Sehir = sehir;
        Ilce = ilce;
        this.CDerece = CDerece;
    }
}
