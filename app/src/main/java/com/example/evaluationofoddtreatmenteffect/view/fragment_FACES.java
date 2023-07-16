package com.example.evaluationofoddtreatmenteffect.view;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.MainActivity;
import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.Presenter.BasePresenter;
import com.example.evaluationofoddtreatmenteffect.Presenter.Presenter;


public class fragment_FACES extends Fragment implements View.OnClickListener,BaseView{

    public static String[] question = new String[30];
    @Override
    public <T> void wenjuan(T[] data) {
        question = (String[]) data;
        textView.setText("问题：\n\n" + question[0]);
    }

    @Override
    public void Display_personal_information(String[] inform) {

    }


    private int count = 1;
    private int score = 0;
    TextView textView;
    public Button button1,button2,button3,button4,button5;

    public BasePresenter precenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faces, container, false);

        textView = view.findViewById(R.id.wen);
        button1 = view.findViewById(R.id.b7);
        button2 = view.findViewById(R.id.b8);
        button3 = view.findViewById(R.id.b9);
        button4 = view.findViewById(R.id.b10);
        button5 = view.findViewById(R.id.b11);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        precenter = new Presenter(fragment_FACES.this);
        precenter.question("FACES.json",30);

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.enable();

        return view;
    }

//    faces问卷题目展示和得分回传
    public void FacesScore(){
        count++;
        Bundle bundle = new Bundle();
        if (count<31){
            textView.setText("问题：\n\n"+question[count-1]);
        }else {
            precenter.WenjuanUpdate(score,"faces");
            bundle.putString("score","您的FACES问卷总得分为："+score);
            fragment_wenjuan wenjuan =new fragment_wenjuan();
            wenjuan.setArguments(bundle);
//            移除wenjuanfragment添加新的wenjuanfragment
            getFragmentManager().beginTransaction()
                    .remove(getActivity().getFragmentManager().findFragmentByTag("wenjuan"))
                    .remove(fragment_FACES.this)
                    .add(R.id.frameLayout,wenjuan,"wenjuan").commit();
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b7:
                score++;
                FacesScore();
                break;
            case R.id.b8:
                score=score+2;
                FacesScore();
                break;
            case R.id.b9:
                score=score+3;
                FacesScore();
                break;
            case R.id.b10:
                score=score+4;
                FacesScore();
                break;
            case R.id.b11:
                score=score+5;
                FacesScore();
                break;
            default:
                break;
        }
    }
}
