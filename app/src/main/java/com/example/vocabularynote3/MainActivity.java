package com.example.vocabularynote3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 메인 화면 리스트
    private ArrayList<VNoteData> arrayList;
    private VNoteAdapter vNoteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    // 인텐트
    private Button mbtn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //메인화면 리스트
        recyclerView = (RecyclerView)findViewById(R.id.mrv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList();

        vNoteAdapter = new VNoteAdapter(arrayList);
        recyclerView.setAdapter(vNoteAdapter);

        mbtn_add = (Button)findViewById(R.id.mbtn_add);
        mbtn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VNoteData vNoteData = new VNoteData("hi");
                arrayList.add(vNoteData);
                vNoteAdapter.notifyDataSetChanged();

                //인텐트
                Intent intent = new Intent(MainActivity.this, VListActivity.class);
                startActivity(intent); // 액티비티 이동


            }
        });






    }
}