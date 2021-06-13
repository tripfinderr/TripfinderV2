package com.crinsoft.sanalturrehberi;

public class GittigimMekanBilgileri {

    private String UserNickName;
    private String GidilenMekan;
    private String Occurrences;

    public void setOccurrences(String occurrences) {
        Occurrences = occurrences;
    }

    public String getOccurrences() {
        return Occurrences;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public String getGidilenMekan() {
        return GidilenMekan;
    }

    public void setUserNickName(String userNickName) {
        UserNickName = userNickName;
    }

    public void setGidilenMekan(String gidilenMekan) {
        GidilenMekan = gidilenMekan;
    }



    public GittigimMekanBilgileri(String userNickName, String gidilenMekan,String occurrences) {
        UserNickName = userNickName;
        GidilenMekan = gidilenMekan;
        Occurrences = occurrences;
    }
}

