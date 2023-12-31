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

public class fragment_API extends Fragment implements View.OnClickListener,BaseView{


    public static  String[] question = new String[9];


    @Override
    public <T> void wenjuan(T[] data) {
        question =(String[]) data;
        textView.setText("问题：\n\n" + question[0]);
    }

    @Override
    public void Display_personal_information(String[] inform) {

    }


    TextView textView;

    private int count = 1;
    private int score = 0;

    public BasePresenter precenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api,container,false);

        textView=view.findViewById(R.id.wen2);
        Button button1=view.findViewById(R.id.b12);
        Button button2=view.findViewById(R.id.b13);
        Button button3=view.findViewById(R.id.b14);
        Button button4=view.findViewById(R.id.b15);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        precenter = new Presenter(fragment_API.this);
        precenter.question("API.json",9);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.enable();
        return view;
    }
//    Api问卷题目展示和得分回传
    public void ApiScore(){
        count++;
        Bundle bundle = new Bundle();
        fragment_wenjuan wenjuan = new fragment_wenjuan();
        if (count < 10) {
            textView.setText("问题：\n\n" + question[count - 1]);
        } else {
            precenter.WenjuanUpdate(score,"api");
            bundle.putString("score", "您的API分量表问卷总得分为：" + score);
            wenjuan.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .remove(getActivity().getFragmentManager().findFragmentByTag("wenjuan"))
                    .remove(fragment_API.this)
                    .add(R.id.frameLayout,wenjuan,"wenjuan").commit();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.b15:
                if (count == 1 | count == 2 | count == 4) {
                    score = score + 4;
                } else {
                    score++;
                }
                ApiScore();
                break;
            case R.id.b14:
                if (count == 1 | count == 2 | count == 4) {
                    score = score + 3;
                } else {
                    score = score + 2;
                }
                ApiScore();
                break;
            case R.id.b13:
                if (count == 1 | count == 2 | count == 4) {
                    score = score + 2;
                } else {
                    score = score + 3;
                }
                ApiScore();
                break;
            case R.id.b12:
                if (count == 1 | count == 2 | count == 4) {
                    score = score + 1;
                } else {
                    score = score + 4;
                }
                ApiScore();
                break;
            default:
                break;
        }
    }
}
