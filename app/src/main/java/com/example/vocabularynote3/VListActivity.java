package com.example.vocabularynote3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import java.util.ArrayList;

public class VListActivity extends AppCompatActivity {

    private ArrayList<VListData> arrayList;
    private VListAdapter vListAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlist);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        vListAdapter = new VListAdapter(this, arrayList);
        recyclerView.setAdapter(vListAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(VListActivity.this, EditItem.class);
//                startActivity(intent);
//                VListData vListData = new VListData("kanji","hatsuon","imi");
//                arrayList.add(vListData);
//                vListAdapter.notifyDataSetChanged();

                AlertDialog.Builder builder = new AlertDialog.Builder(VListActivity.this);
                View view = LayoutInflater.from(VListActivity.this).inflate(R.layout.activity_edit_item, null, false);
                builder.setView(view);
                final Button btn_add = (Button) view.findViewById(R.id.btn_add);
                final EditText edit_kanji = (EditText) view.findViewById(R.id.edit_kanji);
                final EditText edit_hatsuon = (EditText) view.findViewById(R.id.edit_hatsuon);
                final EditText edit_imi = (EditText) view.findViewById(R.id.edit_imi);

                btn_add.setText("삽입");


                final AlertDialog dialog = builder.create();
                btn_add.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String kanji = edit_kanji.getText().toString();
                        String hatsuon = edit_hatsuon.getText().toString();
                        String imi = edit_imi.getText().toString();

                        VListData vListData = new VListData(kanji, hatsuon, imi);

                        arrayList.add(0, vListData);
                        //mArrayList.add(dict); //마지막 줄에 삽입
                        vListAdapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

//    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(VListActivity.this,MainActivity.class);
//        setResult(RESULT_OK, intent);
//        finish();
//        super.onBackPressed();
//    }
        });
    }
}