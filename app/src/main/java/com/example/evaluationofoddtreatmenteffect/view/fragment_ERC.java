package com.example.evaluationofoddtreatmenteffect.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.precenter.BasePrecenter;
import com.example.evaluationofoddtreatmenteffect.precenter.Precenter;

import org.litepal.tablemanager.Connector;

public class fragment_ERC extends Fragment implements View.OnClickListener,BaseView{

    private int count = 1;
    private int score = 0;
    public String [] question =new String[23];

    public Button button1,button2,button3,button4;
    TextView textView;
    BasePrecenter precenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_erc,container,false);

        textView=view.findViewById(R.id.wen4);
        button1=view.findViewById(R.id.b21);
        button2=view.findViewById(R.id.b22);
        button3=view.findViewById(R.id.b23);
        button4=view.findViewById(R.id.b24);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        precenter =new Precenter(fragment_ERC.this);
        precenter.question("ERC.json",23);


        return view;
    }

    public void DersScore(){
        Bundle bundle = new Bundle();
        fragment_wenjuan wenjuan = new fragment_wenjuan();
        count++;
        if (count<24){
            textView.setText("问题：\n\n"+question[count-1]);
        }else {
            precenter.WenjuanUpdate(score,"erc");
            bundle.putString("score","您的ERC问卷总得分为："+score);
            wenjuan.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.frameLayout,wenjuan).commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b21:
                if (count==4|count==5|count==9|count==11|count==15|count==17){
                    score=score+4;
                }else {score++;}
                DersScore();
                break;
            case R.id.b22:
                if (count==4|count==5|count==9|count==11|count==15|count==17){
                    score=score+3;
                }else {score=score+2;}
                DersScore();
                break;
            case R.id.b23:
                if (count==4|count==5|count==9|count==11|count==15|count==17){
                    score=score+2;
                }else {score=score+3;}
                DersScore();
                break;
            case R.id.b24:
                count++;
                if (count==4|count==5|count==9|count==11|count==15|count==17){
                    score=score+1;
                }else {score=score+4;}
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
