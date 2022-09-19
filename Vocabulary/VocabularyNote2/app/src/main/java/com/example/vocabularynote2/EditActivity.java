package com.example.vocabularynote2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private ListView editList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editList = (ListView)findViewById(R.id.editList);

        List<String> data2 = new ArrayList<>();

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_2,data2);
        editList.setAdapter(adapter2);

        data2.add("日本の大学に留学しています。");
        data2.add("みんな教室では日本語で話します。");
        data2.add("学食はとても便利です。");
        adapter2.notifyDataSetChanged();



    }



}