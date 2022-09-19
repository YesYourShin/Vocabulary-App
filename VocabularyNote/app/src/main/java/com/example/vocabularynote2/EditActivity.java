package com.example.vocabularynote2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    // 단어장 안에 단어 리스트 화면

    private ListView editList;
    private ArrayList<ListData> arrayList;
    private ListAdapter listAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private int count = 0;

    private TextView edit_kanji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

//        editList = (ListView)findViewById(R.id.editList);
//
//        List<String> data = new ArrayList<>();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//        editList.setAdapter(adapter);
//
//        data.add("日本の大学に留学しています。");
//        data.add("みんな教室では日本語で話します。");
//        data.add("学食はとても便利です。");
//        adapter.notifyDataSetChanged();


        edit_kanji = findViewById(R.id.edit_kanji);

        Intent intent = getIntent();
        String kanji = intent.getStringExtra("kanji");




        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        listAdapter = new ListAdapter(arrayList);
        recyclerView.setAdapter(listAdapter);

        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, EditItem.class);
                startActivity(intent);
                ListData listData = new ListData(Integer.toString(arrayList.size()+1),kanji,"hatsuon","imi");
                arrayList.add(listData);
                listAdapter.notifyDataSetChanged();


            }
        });
    }



}