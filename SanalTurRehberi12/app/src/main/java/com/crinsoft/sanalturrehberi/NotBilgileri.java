package com.crinsoft.sanalturrehberi;

public class NotBilgileri {


    private String Notlar;
    private String UserNickName;

    private String NotBasligi;


    public String getNotlar() {
        return Notlar;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public String getNotBasligi() {
        return NotBasligi;
    }

    public void setNotlar(String notlar) {
        Notlar = notlar;
    }

    public void setUserNickName(String userNickName) {
        UserNickName = userNickName;
    }

    public void setNotBasligi(String notBasligi) {
        NotBasligi = notBasligi;
    }

    public NotBilgileri(String Notlar, String UserNickName, String NotBasligi) {
        this.Notlar = Notlar;
        this.UserNickName = UserNickName;
        this.NotBasligi = NotBasligi;
    }
}
