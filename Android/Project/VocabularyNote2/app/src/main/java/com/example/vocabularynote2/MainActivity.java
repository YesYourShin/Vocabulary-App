package com.example.vocabularynote2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private ListView list;
    private FloatingActionButton addList;

    private ArrayList<VNoteData> arrayList;
    private VNoteAdapter vNoteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        list = (ListView)findViewById(R.id.list);
//
//        List<String> data = new ArrayList<>();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//        list.setAdapter(adapter);
//
//        data.add("사과");
//        data.add("바나나");
//        data.add("포도");
//        adapter.notifyDataSetChanged();


        recyclerView = (RecyclerView)findViewById(R.id.mrv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((linearLayoutManager));

        arrayList = new ArrayList<>();

        vNoteAdapter = new VNoteAdapter(arrayList);
        recyclerView.setAdapter(vNoteAdapter);



        addList = findViewById(R.id.addList);
        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, EditItem.class);
                startActivity(intent);

                VNoteData vNoteData = new VNoteData(Integer.toString(arrayList.size()+1));
                arrayList.add(vNoteData);
                vNoteAdapter.notifyDataSetChanged();

            }
        });




        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}