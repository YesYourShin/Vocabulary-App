package com.example.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.util.ArrayList;

public class VListActivity extends AppCompatActivity {

    // 단어 리스트 화면

    private ArrayList<VListData> arrayList;
    private VListAdapter vListAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlist);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        vListAdapter = new VListAdapter(arrayList);
        recyclerView.setAdapter(vListAdapter);

        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VListActivity.this, EditItem.class);
                startActivity(intent);
                VListData vListData = new VListData("kanji","hatsuon","imi");
                arrayList.add(vListData);
                vListAdapter.notifyDataSetChanged();


            }
        });
    }

//    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(VListActivity.this,MainActivity.class);
//        setResult(RESULT_OK, intent);
//        finish();
//        super.onBackPressed();
//    }

}