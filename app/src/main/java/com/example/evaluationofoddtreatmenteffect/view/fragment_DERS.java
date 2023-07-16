package com.example.evaluationofoddtreatmenteffect.view;

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

public class fragment_DERS extends Fragment implements View.OnClickListener,BaseView{

    private int count = 1;
    private int score = 0;
    private String [] question =new String[36];
    public Button button1,button2,button3,button4,button5;
    TextView textView;

    public BasePresenter precenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ders,container,false);


        textView=view.findViewById(R.id.wen3);
        button1=view.findViewById(R.id.b16);
        button2=view.findViewById(R.id.b17);
        button3=view.findViewById(R.id.b18);
        button4=view.findViewById(R.id.b19);
        button5=view.findViewById(R.id.b20);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        precenter =new Presenter(fragment_DERS.this);
        precenter.question("DERS.json",36);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.enable();
        return view;
    }

//    ders问卷题目展示和得分回传
    public void DersScore(){
        Bundle bundle = new Bundle();
        fragment_wenjuan wenjuan = new fragment_wenjuan();
        count++;
        if (count<37){
            textView.setText("问题：\n\n"+question[count-1]);
        }else {
            precenter.WenjuanUpdate(score,"ders");
            bundle.putString("score","您的DERS问卷总得分为："+score);
            wenjuan.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .remove(getActivity().getFragmentManager().findFragmentByTag("wenjuan"))
                    .remove(fragment_DERS.this)
                    .add(R.id.frameLayout,wenjuan,"wenjuan").commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b16:
                score++;
                DersScore();
                break;
            case R.id.b17:
                score=score+2;
                DersScore();
                break;
            case R.id.b18:
                score=score+3;
                DersScore();
                break;
            case R.id.b19:
                score=score+4;
                DersScore();
                break;
            case R.id.b20:
                score=score+5;
                DersScore();
                break;
            default:
                break;
        }
    }

    @Override
    public <T> void wenjuan(T[] data) {
        question =(String[]) data;
        textView.setText("问题：\n\n" + question[0]);
    }

    @Override
    public void Display_personal_information(String[] inform) {

    }

}
