package com.example.evaluationofoddtreatmenteffect.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.precenter.BasePrecenter;
import com.example.evaluationofoddtreatmenteffect.precenter.Precenter;

import org.litepal.tablemanager.Connector;

public class fragment_set extends Fragment implements BaseView {

    public EditText text;
    public Button button;
    public BasePrecenter precenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set,container,false);

        text = view.findViewById(R.id.tv);

//        显示提示词
        if(getArguments()!=null){
            text.setHint(getArguments().get("1").toString());
        }

        precenter = new Precenter(fragment_set.this);

        button = view.findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
//            跳转同时将填写的消息通过prcenter存入数据库对应位置
            @Override
            public void onClick(View view) {
                if(getArguments().get("1").toString().contains("手机")){
                    precenter.InformationUpdate(text.getText().toString(),"phone");
                } else if (getArguments().get("1").toString().contains("邮箱")) {
                    precenter.InformationUpdate(text.getText().toString(),"mail");
                }else{
                    precenter.InformationUpdate(text.getText().toString(),"wechat");
                }
                fragment_shezhi shezhi = new fragment_shezhi();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,shezhi).commit();
            }
        });

        return view;
    }


    @Override
    public <T> void wenjuan(T[] data) {

    }

    @Override
    public void Display_personal_information(String[] inform) {

    }
}
