package com.example.test;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VocaListAdapter extends RecyclerView.Adapter<VocaListAdapter.CustomViewHolder>{


    private ArrayList<VListData> arrayList;

    public VocaListAdapter(ArrayList<VListData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VocaListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vlist_item_list,parent,false);
        VocaListAdapter.CustomViewHolder holder = new VocaListAdapter.CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VocaListAdapter.CustomViewHolder holder, int position) {
        holder.kanji.setText(arrayList.get(position).getKanji());
        holder.hatsuon.setText(arrayList.get(position).getHatsuon());
        holder.imi.setText(arrayList.get(position).getImi());


        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(v.getContext(), EditItem.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView kanji;
        protected TextView hatsuon;
        protected TextView imi;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.kanji = (TextView) itemView.findViewById(R.id.kanji);
            this.hatsuon = (TextView) itemView.findViewById(R.id.hatsuon);
            this.imi = (TextView) itemView.findViewById(R.id.imi);
        }
    }
}
