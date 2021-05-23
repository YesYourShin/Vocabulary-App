package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EditItem extends AppCompatActivity {

    // 단어 리스트 단어 편집 화면

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
                imi = edit_imi.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditItem.this, VListActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                VocabularyRequest vocabularyRequest = new VocabularyRequest(kanji, hatsuon, imi, responseListener);
                RequestQueue queue = Volley.newRequestQueue(EditItem.this);
                queue.add(VocabularyRequest);

//                vintent.putExtra("kanji",kanji);
//                vintent.putExtra("hatsuon",hatsuon);
//                vintent.putExtra("imi",imi);
                Intent intent = new Intent(EditItem.this,VListActivity.class);
                Intent vintent = new Intent(EditItem.this, VocaListAdapter.class);

                setResult(RESULT_OK,intent);
                finish();
//                startActivity(intent);
            }
        });
    }
}