package com.example.test;

public class VListData {

    // 단어 리스트 화면

    private String kanji;
    private String hatsuon;
    private String imi;

    public VListData(String kanji, String hatsuon, String imi) {
        this.kanji = kanji;
        this.hatsuon = hatsuon;
        this.imi = imi;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getHatsuon() {
        return hatsuon;
    }

    public void setHatsuon(String hatsuon) {
        this.hatsuon = hatsuon;
    }

    public String getImi() {
        return imi;
    }

    public void setImi(String imi) {
        this.imi = imi;
    }
}
