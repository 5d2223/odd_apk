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

//recycleview适配器
public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

//    列表数据
    private List<jieshao> list;

//    更新数据
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

//    viewholder中的布局和数据想绑定设置
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mess.setText(list.get(position).getJieshao());
        holder.img.setImageResource(list.get(position).getImg());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

//    自定义个recycleview的ViewHolder将viewholder与item子类布局相关联
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
