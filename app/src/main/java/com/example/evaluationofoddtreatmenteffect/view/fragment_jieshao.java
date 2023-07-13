package com.example.evaluationofoddtreatmenteffect.view;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.adapter.myAdapter;
import com.example.evaluationofoddtreatmenteffect.bean.jieshao;
import com.example.evaluationofoddtreatmenteffect.Presenter.BasePresenter;
import com.example.evaluationofoddtreatmenteffect.Presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class fragment_jieshao extends Fragment implements BaseView{

    public BasePresenter precenter;
    public RecyclerView recyclerView;

    public myAdapter myAdapter;

    public List<com.example.evaluationofoddtreatmenteffect.bean.jieshao> wenjuan =new ArrayList<>();

    public String[] text = new String[5];

    jieshao jieshao,jieshao1,jieshao2,jieshao3,jieshao4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        precenter =new Presenter(fragment_jieshao.this);
        precenter.question("wenjuan.json",5);

        View view = inflater.inflate(R.layout.fragment_jieshao,container,false);
        recyclerView = view.findViewById(R.id.RV);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new myAdapter(wenjuan);
        recyclerView.setAdapter(myAdapter);

        return  view;
    }

    Handler handler = new Handler(Looper.getMainLooper());

    int count =0;


//    从网络请求介绍文字并更新recycleview
    @Override
    public <T> void wenjuan(T[] data) {
        text = (String[]) data;
        handler.post(new Runnable() {
            @Override
            public void run() {
                jieshao=new jieshao(text[0], R.drawable.odd);
                jieshao1=new jieshao(text[1], R.drawable.faces);
                jieshao2=new jieshao(text[2], R.drawable.api);
                jieshao3=new jieshao(text[3], R.drawable.ders);
                jieshao4=new jieshao(text[4], R.drawable.erc);

                wenjuan.add(jieshao);
                wenjuan.add(jieshao1);
                wenjuan.add(jieshao2);
                wenjuan.add(jieshao3);
                wenjuan.add(jieshao4);
                myAdapter.setData(wenjuan);
                myAdapter.notifyDataSetChanged();
            }
        });
        Log.d("问卷介绍",text[0] );
    }

    @Override
    public void Display_personal_information(String[] inform) {

    }
}
