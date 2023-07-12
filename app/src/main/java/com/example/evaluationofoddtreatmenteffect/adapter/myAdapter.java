package com.example.evaluationofoddtreatmenteffect.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.bean.jieshao;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

    private List<jieshao> list;

    public void setData(List<jieshao> List){
        list = List;
    }

    public myAdapter(List<jieshao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mess.setText(list.get(position).getJieshao());
        holder.img.setImageResource(list.get(position).getImg());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mess;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mess = itemView.findViewById(R.id.mess);
            img=itemView.findViewById(R.id.img);
        }
    }

}
