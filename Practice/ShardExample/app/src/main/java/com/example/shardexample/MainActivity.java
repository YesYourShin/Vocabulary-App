package com.example.shardexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shard = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save =(EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shard,0);
        String value = sharedPreferences.getString("Hello World", "");
        et_save.setText(value);

    }

    @Override
    protected void onDestroy() { // 앱을 종료를 시켰을 때, 뒤로가기를 누르거나 액티비티를 벗어났을 때
                                // 액티비티가 파괴되는데 그때 호출됐을 때 여기서 실행을 할 수가 있음
                                // 저장을 시키면서 빠져나가고 앱을 재실행 했을 때
                                // 여기서 저장했던 것을 저기서 불러옴
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shard,0);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //저장을 할 때 항상 Editor를 불러와야 됨
        String value = et_save.getText().toString(); //editText에 뭔가를 입력했을 때 그 값을 받아오는 것이 getText
        editor.putString("Hello World", value); //String 형태로 저장
        editor.commit(); //세이브를 완료해라

    }
}