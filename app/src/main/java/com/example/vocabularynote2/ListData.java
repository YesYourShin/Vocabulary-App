package com.example.vocabularynote2;

public class ListData {

    private String num;
    private String kanji;
    private String hatsuon;
    private String imi;

    public ListData(String num, String kanji, String hatsuon, String imi) {
        this.num = num;
        this.kanji = kanji;
        this.hatsuon = hatsuon;
        this.imi = imi;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
