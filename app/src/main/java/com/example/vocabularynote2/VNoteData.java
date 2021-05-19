package com.example.vocabularynote2;

public class VNoteData {

    // 단어장 이름 리스트

    private String list_title;

    public VNoteData(String list_title) {
        this.list_title = list_title;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }
}
