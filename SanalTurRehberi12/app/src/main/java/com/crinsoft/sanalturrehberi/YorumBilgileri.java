package com.crinsoft.sanalturrehberi;

public class YorumBilgileri {
    String UserNickName;
    String TurIsmi;
    String MekanIsimleri;
    String MekanYorumu;


    public YorumBilgileri(String userNickName, String turIsmi, String mekanIsimleri, String mekanYorumu) {
        UserNickName = userNickName;
        TurIsmi = turIsmi;
        MekanIsimleri = mekanIsimleri;
        MekanYorumu = mekanYorumu;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public String getTurIsmi() {
        return TurIsmi;
    }

    public String getMekanIsimleri() {
        return MekanIsimleri;
    }

    public String getMekanYorumu() {
        return MekanYorumu;
    }

    public void setUserNickName(String userNickName) {
        UserNickName = userNickName;
    }

    public void setTurIsmi(String turIsmi) {
        TurIsmi = turIsmi;
    }

    public void setMekanIsimleri(String mekanIsimleri) {
        MekanIsimleri = mekanIsimleri;
    }

    public void setMekanYorumu(String mekanYorumu) {
        MekanYorumu = mekanYorumu;
    }
}
