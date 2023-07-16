package com.example.evaluationofoddtreatmenteffect;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.evaluationofoddtreatmenteffect.view.fragment_jieshao;
import com.example.evaluationofoddtreatmenteffect.view.fragment_shezhi;
import com.example.evaluationofoddtreatmenteffect.view.fragment_wenjuan;
import com.example.evaluationofoddtreatmenteffect.view.fragment_zhu;

//宿主活动用于展示各个fragment
public class MainActivity extends BaseActivity implements View.OnClickListener {

    public Button zhuye,jieshao,wenjuan,shezhi,back,notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
    }

//    跳转fragment
    public void JumpFrag(String frag){
        switch (frag) {
            case "zhuye":
                fragment_zhu zhu = new fragment_zhu();
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, zhu).commit();
                break;
            case "jieshao":
                fragment_jieshao jieshao = new fragment_jieshao();
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, jieshao).commit();
                break;
            case "wenjuan":
                fragment_wenjuan wenjuan = new fragment_wenjuan();
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, wenjuan).commit();
                break;
            case "shezhi":
                fragment_shezhi shezhi = new fragment_shezhi();
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, shezhi).commit();
                break;
        }
    }

//    初始化视图
    public void initview(){
        JumpFrag("zhuye");

        zhuye = findViewById(R.id.zhuye);
        jieshao = findViewById(R.id.jieshao);
        wenjuan = findViewById(R.id.wenjuan);
        shezhi = findViewById(R.id.shezhi);
        back = findViewById(R.id.back);
        notice = findViewById(R.id.notice);

        zhuye.setOnClickListener(this);
        jieshao.setOnClickListener(this);
        wenjuan.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        back.setOnClickListener(this);
        notice.setOnClickListener(this);

    }

//    跳转按钮背景变化
    public void ButtonBackground(String bt){
        switch (bt) {
            case "zhuye":
                zhuye.setBackgroundResource(R.drawable.home_fill);
                jieshao.setBackgroundResource(R.drawable.question);
                wenjuan .setBackgroundResource(R.drawable.log);
                shezhi.setBackgroundResource(R.drawable.people);
                break;
            case "jieshao":
                zhuye.setBackgroundResource(R.drawable.shou);
                jieshao.setBackgroundResource(R.drawable.question_fill);
                wenjuan .setBackgroundResource(R.drawable.log);
                shezhi.setBackgroundResource(R.drawable.people);
                break;
            case "wenjuan":
                zhuye.setBackgroundResource(R.drawable.shou);
                jieshao.setBackgroundResource(R.drawable.question);
                wenjuan .setBackgroundResource(R.drawable.text);
                shezhi.setBackgroundResource(R.drawable.people);
                break;
            case "shezhi":
                zhuye.setBackgroundResource(R.drawable.shou);
                jieshao.setBackgroundResource(R.drawable.question);
                wenjuan.setBackgroundResource(R.drawable.log);
                shezhi.setBackgroundResource(R.drawable.people_fill);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuye:
            case R.id.back:
                JumpFrag("zhuye");
                ButtonBackground("zhuye");
                break;
            case R.id.jieshao:
                JumpFrag("jieshao");
                ButtonBackground("jieshao");
                break;
            case R.id.wenjuan:
                JumpFrag("wenjuan");
                ButtonBackground("wenjuan");
                break;
            case R.id.shezhi:
                JumpFrag("shezhi");
                ButtonBackground("shezhi");
                break;
            case R.id.notice:
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("注意");
                builder.setMessage("本软件采用匿名形式，若您需要完整的问卷结果信息可以在个人信息界面填写邮箱等信息并点击发送结果按钮，详细结果会发送到您指定的邮箱里");
                builder.setPositiveButton("了解",null);
                builder.show();
                break;

            default:
                break;
        }
    }
}