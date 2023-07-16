package com.example.evaluationofoddtreatmenteffect.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.MainActivity;
import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.getbase.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;

import java.util.ArrayList;

public class fragment_ODD extends Fragment {
    results results = new results();
    public MainActivity mainActivity;
    private ArrayList<CheckBox> checkBoxes =new ArrayList<>();

    public int score=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_odd,container,false);

        FloatingActionButton button = view.findViewById(R.id.fb1);

        CheckBox checkBox1 =view.findViewById(R.id.cb1);
        CheckBox checkBox2 =view.findViewById(R.id.cb2);
        CheckBox checkBox3 =view.findViewById(R.id.cb3);
        CheckBox checkBox4 =view.findViewById(R.id.cb4);
        CheckBox checkBox5 =view.findViewById(R.id.cb5);
        CheckBox checkBox6 =view.findViewById(R.id.cb6);
        CheckBox checkBox7 =view.findViewById(R.id.cb7);
        CheckBox checkBox8 =view.findViewById(R.id.cb8);

        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);
        checkBoxes.add(checkBox5);
        checkBoxes.add(checkBox6);
        checkBoxes.add(checkBox7);
        checkBoxes.add(checkBox8);

        mainActivity = (MainActivity) getActivity();
        mainActivity.enable();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (CheckBox checkBox:checkBoxes){
                    if (checkBox.isChecked()){
                        score=score+1;
                    }
                }
                if (LitePal.isExist(results.getClass(),"id=1")){

                    results.setODD(score);
                    results.updateAll("id=?","1");
                }else {
                    results.setODD(score);
                    results.save();
                }

                Bundle bundle = new Bundle();
                fragment_wenjuan wenjuan =new fragment_wenjuan();
                if (score==0){
                    String scores = String.valueOf(score);
                    bundle.putString("score","您的孩子的ODD评分为："+scores+"分\n\n"+"您的孩子十分健康。如仍希望继续进行其他问卷的检测可点击问卷按钮！");
                    wenjuan.setArguments(bundle);

                } else if (score>0&&score<4) {
                    String scores = String.valueOf(score);
                    bundle.putString("score","您的孩子的ODD评分为："+scores+"分\n\n"+"您的孩子存在有身患ODD的风险。如仍希望继续进行其他问卷的检测可点击问卷按钮！");
                    wenjuan.setArguments(bundle);
                }else {
                    String scores = String.valueOf(score);
                    bundle.putString("score","您的孩子的ODD评分为："+scores+"分\n\n"+"您的孩子极大概率身患ODD。请务必点击问卷按钮进行其他问卷！检测结果可以为您孩子的治疗方案提供参考！");
                    wenjuan.setArguments(bundle);
                }
                getFragmentManager().beginTransaction()
                        .remove(getActivity().getFragmentManager().findFragmentByTag("wenjuan"))
                        .remove(fragment_ODD.this)
                        .add(R.id.frameLayout,wenjuan,"wenjuan").commit();
            }
        });

        return view;
    }
}
