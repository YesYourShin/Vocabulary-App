package com.example.vocabularynote3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItem extends AppCompatActivity {

    private Button btn_add;
    private EditText edit_kanji;
    private String kanji;
    private EditText edit_hatsuon;
    private String hatsuon;
    private EditText edit_imi;
    private String imi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent intent = new Intent(getApplicationContext(), VListActivity.class);

        edit_kanji = findViewById(R.id.edit_kanji);
        edit_hatsuon = findViewById(R.id.edit_hatsuon);
        edit_imi = findViewById(R.id.edit_imi);


        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kanji = edit_kanji.getText().toString();
                hatsuon = edit_hatsuon.getText().toString();
                kanji = edit_kanji.getText().toString();
                intent.putExtra("kanji",kanji);
                intent.putExtra("hatsuon",hatsuon);
                intent.putExtra("imi",imi);
                Intent intent = new Intent(EditItem.this,VListActivity.class);

                setResult(RESULT_OK,intent);
                finish();
//                startActivity(intent);
            }
        });
    }
}