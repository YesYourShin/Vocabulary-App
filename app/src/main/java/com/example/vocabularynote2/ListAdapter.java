package com.example.vocabularynote2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {

    private ArrayList<ListData> arrayList; // 리스트 뷰에 아이템을 담을 ArrayList

    public ListAdapter(ArrayList<ListData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.CustomViewHolder holder, int position) {
        holder.num.setText(arrayList.get(position).getNum());
        holder.kanji.setText(arrayList.get(position).getKanji());
        holder.hatsuon.setText(arrayList.get(position).getHatsuon());
        holder.imi.setText(arrayList.get(position).getImi());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                String curName = holder.kanji.getText().toString();
//                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();;

                Intent intent = new Intent(v.getContext(), EditItem.class);
                v.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView num;
        protected TextView kanji;
        protected TextView hatsuon;
        protected TextView imi;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.num = (TextView) itemView.findViewById(R.id.num);
            this.kanji = (TextView) itemView.findViewById(R.id.kanji);
            this.hatsuon = (TextView) itemView.findViewById(R.id.hatsuon);
            this.imi = (TextView) itemView.findViewById(R.id.imi);
        }
    }
}
