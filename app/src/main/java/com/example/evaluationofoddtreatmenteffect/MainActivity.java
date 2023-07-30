package com.example.evaluationofoddtreatmenteffect;

import androidx.appcompat.app.AlertDialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.evaluationofoddtreatmenteffect.view.fragment_jieshao;
import com.example.evaluationofoddtreatmenteffect.view.fragment_shezhi;
import com.example.evaluationofoddtreatmenteffect.view.fragment_wenjuan;
import com.example.evaluationofoddtreatmenteffect.view.fragment_zhu;

import butterknife.BindView;
import butterknife.ButterKnife;

//宿主活动用于展示各个fragment
public class MainActivity extends BaseActivity implements View.OnClickListener {

    public fragment_zhu f_zhu = new fragment_zhu();
    public fragment_jieshao f_jieshao = new fragment_jieshao();
    public fragment_wenjuan f_wenjuan;
    public fragment_shezhi f_shezhi = new fragment_shezhi();

    @BindView(R.id.zhuye)
    Button zhuye;

    @BindView(R.id.jieshao)
    Button jieshao;
    @BindView(R.id.wenjuan)
    Button wenjuan;
    @BindView(R.id.shezhi)
    Button shezhi;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.notice)
    Button notice;

//    更新wenjuanfragment
    public void setWenjuan(fragment_wenjuan wenjuan){
        f_wenjuan=wenjuan;
    }

//    设置按钮为不可点击
    public void enable(){
        zhuye.setEnabled(false);
        jieshao.setEnabled(false);
        wenjuan.setEnabled(false);
        shezhi.setEnabled(false);
    }

//    设置按钮为可点击
    public void able(){
        zhuye.setEnabled(true);
        jieshao.setEnabled(true);
        wenjuan.setEnabled(true);
        shezhi.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initview();
    }

//    跳转fragment
    public void JumpFrag(String frag){
        switch (frag) {
            case "zhuye":
                getFragmentManager().beginTransaction().show(f_zhu).hide(f_jieshao).hide(f_wenjuan).hide(f_shezhi).commit();
                break;
            case "jieshao":
                getFragmentManager().beginTransaction().show(f_jieshao).hide(f_zhu).hide(f_wenjuan).hide(f_shezhi).commit();
                break;
            case "wenjuan":
                getFragmentManager().beginTransaction().show(f_wenjuan).hide(f_jieshao).hide(f_zhu).hide(f_shezhi).commit();
                break;
            case "shezhi":
                getFragmentManager().beginTransaction().show(f_shezhi).hide(f_jieshao).hide(f_wenjuan).hide(f_zhu).commit();
                break;
        }
    }


//    初始化视图
    public void initview(){

        zhuye.setOnClickListener(this);
        jieshao.setOnClickListener(this);
        wenjuan.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        back.setOnClickListener(this);
        notice.setOnClickListener(this);

        if(getFragmentManager().findFragmentByTag("wenjuan")==null){
            f_wenjuan = new fragment_wenjuan();
        }else {
            f_wenjuan = (fragment_wenjuan) getFragmentManager().findFragmentByTag("wenjuan");
        }

        getFragmentManager().beginTransaction()
                .add(R.id.frameLayout,f_zhu,"zhu")
                .add(R.id.frameLayout,f_jieshao,"jieshao")
                .add(R.id.frameLayout,f_wenjuan,"wenjuan")
                .add(R.id.frameLayout,f_shezhi,"shezhi")
                .commit();

        JumpFrag("zhuye");
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