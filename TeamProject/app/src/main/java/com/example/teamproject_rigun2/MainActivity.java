package com.example.teamproject_rigun2;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    private Object courseButton;

//    TableLayout tableLayout;
//    TableLayout tableLayout1;
//
//    private RadioGroup courseUniversityGroup;
//    private RadioButton Aclass, Bclass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 공지사항 작성란
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("현충일", " 6월 6일", ""));
        noticeList.add(new Notice("기말고사", " 6월14일(월)~18일(금)", ""));
        noticeList.add(new Notice("하계방학", " 6월21일(월)~8월27일(금)", ""));
        noticeList.add(new Notice("청해진 예비자과정 전공특강", " 6월28일(월) 14시~17시 (월~금)", ""));
        noticeList.add(new Notice(" JLPT 시험", " 7월4일(일)", ""));
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);


        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button vocabularynoteButton = (Button) findViewById(R.id.vocabularynoteButton);

        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);


        courseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.logo));
                vocabularynoteButton.setBackgroundColor(getResources().getColor(R.color.logo));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new RestaurantFragment());
                fragmentTransaction.commit();


            }
        });


        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.logo));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.logo));
                vocabularynoteButton.setBackgroundColor(getResources().getColor(R.color.logo));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();


            }
        });


        vocabularynoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.logo));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.logo));
                vocabularynoteButton.setBackgroundColor(getResources().getColor(R.color.logo));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new VocabularyNoteFragment());
                fragmentTransaction.commit();


            }
        });



//        // Schedule 라디오 그룹 객체 생성
//        courseUniversityGroup = findViewById(R.id.courseUniversityGroup);
//
//
//        // 5/22 스케쥴 에있는 A반 , B반 버튼에 대한 객체 생성
//        Aclass = findViewById(R.id.Aclass);
//        Bclass = findViewById(R.id.Bclass);
//
//        courseUniversityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.Aclass) {
//                    Toast.makeText(MainActivity.this,"A반 시간표",Toast.LENGTH_SHORT).show();
//
//                } else if (checkedId == R.id.Bclass) {
//                    Toast.makeText(MainActivity.this,"B반 시간표",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                    startActivity(intent);
//                }
//
//            }
//        });




    }

    // Toast 메세지
    //  Toast.makeText(getApplicationContext(), "버튼이 눌렀습니다!",Toast.LENGTH_SHORT).show();

    public void onButtonClicked1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        startActivity(intent);
    }

    public void onButtonClicked2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.daum.net"));
        startActivity(intent);
    }

    private long lastTimeBackPressed;

    // 05-29 메인화면에서 뒤로가기 누르는 설정
    // https://www.youtube.com/watch?v=4hVFvrAVU_M&list=PLRx0vPvlEmdD862e43ADbvDeGPUZKDuqL&index=9  홍드로이드 9강 14분
    // 프래그먼트에서 수정을 해야 동작됨 !!!

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();

    }


//    final Button courseButton = (Button) findViewById(R.id.courseButton);
//    final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
//    final Button vocabularynoteButton = (Button) findViewById(R.id.vocabularynoteButton);


    public void onButton1(View view) {

    }

    public void onButton2(View view) {
    }

    public void onButton3(View view) {
    }
}