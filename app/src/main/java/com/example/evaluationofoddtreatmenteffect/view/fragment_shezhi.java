package com.example.evaluationofoddtreatmenteffect.view;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.evaluationofoddtreatmenteffect.R;
import com.example.evaluationofoddtreatmenteffect.Presenter.BasePresenter;
import com.example.evaluationofoddtreatmenteffect.Presenter.Presenter;

import java.util.Objects;

public class fragment_shezhi extends Fragment implements View.OnClickListener,BaseView{

    public Button tian1,tian2,tian3,send,quit;
    public TextView phone,mail,wechat;


    BasePresenter precenter;


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

        precenter = new Presenter(fragment_shezhi.this);
        precenter.DatabaseShow();


        return view;
    }
    //    跳转至填写信息的fragment并携带bundle用于判断是填写哪类信息
    public void tianxie(String tip){
        fragment_set set1 = new fragment_set();
        Bundle bundle1 = new Bundle();
        bundle1.putString("1",tip);
        set1.setArguments(bundle1);
        getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,set1).commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tian1:
                tianxie("请输入手机号！");
                break;
            case R.id.tian2:
                tianxie("请输入邮箱！");
                break;
            case R.id.tian3:
                tianxie("请输入微信！");
                break;
            case R.id.send:
//                调用发送邮件功能并弹出Dialog提示成功之后跳转至浏览器页面查询
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

//    从precenter调用show方法之后回调方法用于展示个人信息
    @Override
    public void Display_personal_information(String[] inform) {
        if(!Objects.equals(inform[0], "0")){
            phone.setText("手机："+inform[0]);
        }else {
            phone.setText("手机");
        }
        if(!Objects.equals(inform[1], "0")){
            mail.setText("邮箱："+inform[1]);
        }else{
            mail.setText("邮箱");
        }
        if(!Objects.equals(inform[2], "0")){
            wechat.setText("微信："+inform[2]);
        }else {
            wechat.setText("微信");
        }
    }

}
