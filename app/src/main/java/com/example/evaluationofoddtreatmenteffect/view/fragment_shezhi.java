package com.example.evaluationofoddtreatmenteffect.view;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.precenter.BasePrecenter;
import com.example.evaluationofoddtreatmenteffect.precenter.Precenter;

public class fragment_shezhi extends Fragment implements View.OnClickListener,BaseView{

    public Button tian1,tian2,tian3,send,quit;
    public TextView phone,mail,wechat;

    BasePrecenter precenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shezhi,container,false);
        tian1 = view.findViewById(R.id.tian1);
        tian2 = view.findViewById(R.id.tian2);
        tian3 = view.findViewById(R.id.tian3);
        send = view.findViewById(R.id.send);
        quit = view.findViewById(R.id.quit);

        phone = view.findViewById(R.id.ph);
        mail = view.findViewById(R.id.mail);
        wechat = view.findViewById(R.id.chat);

        tian1.setOnClickListener(this);
        tian2.setOnClickListener(this);
        tian3.setOnClickListener(this);
        send.setOnClickListener(this);
        quit.setOnClickListener(this);

        precenter = new Precenter(fragment_shezhi.this);
        precenter.DatabaseShow();


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tian1:
                fragment_set set1 = new fragment_set();
                Bundle bundle1 = new Bundle();
                bundle1.putString("1","请输入手机号！");
                set1.setArguments(bundle1);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,set1).commit();
                break;
            case R.id.tian2:
                fragment_set set2 = new fragment_set();
                Bundle bundle2 = new Bundle();
                bundle2.putString("1","请输入邮箱！");
                set2.setArguments(bundle2);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,set2).commit();
                break;
            case R.id.tian3:
                fragment_set set3 = new fragment_set();
                Bundle bundle3 = new Bundle();
                bundle3.putString("1","请输入微信！");
                set3.setArguments(bundle3);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,set3).commit();
                break;
            case R.id.send:
                precenter.sendEmail();

                AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("注意");
                builder.setMessage("详细的评估结果已经发送到您的指定邮箱，您可以点击确认转入网页到对应网站查询结果！");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse("http://www.baidu.com"));
                        startActivity(intent);
                    }
                }).show();
                break;
            case R.id.quit:
                getActivity().finish();
                break;
            default:
                break;
        }

    }

    @Override
    public <T> void wenjuan(T[] data) {

    }

    @Override
    public void Display_personal_information(String[] inform) {
        if(inform[0]!=null){
            phone.setText("手机："+inform[0]);
        }else {
            phone.setText("手机");
        }
        if(inform[1]!=null){
            mail.setText("邮箱："+inform[1]);
        }else{
            mail.setText("邮箱");
        }
        if(inform[2]!=null){
            wechat.setText("微信："+inform[2]);
        }else {
            wechat.setText("微信");
        }
    }

}
