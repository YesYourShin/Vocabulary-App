package com.example.vocabularynote3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class VListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlist);



//        Button btn_add = (Button)findViewById(R.id.btn_add);
//        btn_add.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(VListActivity.this, MainActivity.class);
//                startActivity(intent);
//                ListData listData = new ListData(Integer.toString(arrayList.size()+1),kanji,"hatsuon","imi");
//                arrayList.add(listData);
//                listAdapter.notifyDataSetChanged();
//
//
//            }
//        });
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