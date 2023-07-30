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
import com.example.evaluationofoddtreatmenteffect.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class fragment_wenjuan extends Fragment implements View.OnClickListener{

    @BindView(R.id.fa)
    public Button faces;
    @BindView(R.id.erc)
    Button erc;
    @BindView(R.id.ders)
    Button ders;
    @BindView(R.id.api)
    Button api;
    @BindView(R.id.odd)
    Button odd;

    @BindView(R.id.show)
    public TextView show;

    public fragment_FACES FACES = new fragment_FACES();
    public fragment_ERC ERC = new fragment_ERC();
    public fragment_DERS DERS = new fragment_DERS();
    public fragment_API API = new fragment_API();
    public fragment_ODD ODD = new fragment_ODD();

    public void ButtonBackground(){
        if(getArguments()!=null){
            show.setText(getArguments().get("score").toString());
            if(getArguments().get("score").toString().contains("ODD")){
                odd.setBackgroundResource(R.drawable.button);
                faces.setBackgroundResource(R.drawable.button3);
                api.setBackgroundResource(R.drawable.button);
                ders.setBackgroundResource(R.drawable.button);
                erc.setBackgroundResource(R.drawable.button);
                odd.setEnabled(false);
                faces.setEnabled(true);
                api.setEnabled(false);
                ders.setEnabled(false);
                erc.setEnabled(false);
            } else if (getArguments().get("score").toString().contains("FACES")) {
                odd.setBackgroundResource(R.drawable.button);
                faces.setBackgroundResource(R.drawable.button);
                api.setBackgroundResource(R.drawable.button3);
                ders.setBackgroundResource(R.drawable.button);
                erc.setBackgroundResource(R.drawable.button);
                odd.setEnabled(false);
                faces.setEnabled(false);
                api.setEnabled(true);
                ders.setEnabled(false);
                erc.setEnabled(false);
            } else if (getArguments().get("score").toString().contains("API")) {
                odd.setBackgroundResource(R.drawable.button);
                faces.setBackgroundResource(R.drawable.button);
                api.setBackgroundResource(R.drawable.button);
                ders.setBackgroundResource(R.drawable.button3);
                erc.setBackgroundResource(R.drawable.button);
                odd.setEnabled(false);
                faces.setEnabled(false);
                api.setEnabled(false);
                ders.setEnabled(true);
                erc.setEnabled(false);
            }else if (getArguments().get("score").toString().contains("DERS")){
                odd.setBackgroundResource(R.drawable.button);
                faces.setBackgroundResource(R.drawable.button);
                api.setBackgroundResource(R.drawable.button);
                ders.setBackgroundResource(R.drawable.button);
                erc.setBackgroundResource(R.drawable.button3);
                odd.setEnabled(false);
                faces.setEnabled(false);
                api.setEnabled(false);
                ders.setEnabled(false);
                erc.setEnabled(true);
            }else {
                odd.setBackgroundResource(R.drawable.button);
                faces.setBackgroundResource(R.drawable.button);
                api.setBackgroundResource(R.drawable.button);
                ders.setBackgroundResource(R.drawable.button);
                erc.setBackgroundResource(R.drawable.button);
                odd.setEnabled(false);
                faces.setEnabled(false);
                api.setEnabled(false);
                ders.setEnabled(false);
                erc.setEnabled(false);
            }
        }else {
            odd.setBackgroundResource(R.drawable.button3);
            faces.setBackgroundResource(R.drawable.button);
            api.setBackgroundResource(R.drawable.button);
            ders.setBackgroundResource(R.drawable.button);
            erc.setBackgroundResource(R.drawable.button);
            odd.setEnabled(true);
            faces.setEnabled(false);
            api.setEnabled(false);
            ders.setEnabled(false);
            erc.setEnabled(false);
            show.setText("尚没有问卷结果！您可在做完所有问卷后到个人信息界面填写信息获取最终结果。");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wenjuan,container,false);
        ButterKnife.bind(this,view);

        faces.setOnClickListener(this);
        erc.setOnClickListener(this);
        ders.setOnClickListener(this);
        api.setOnClickListener(this);
        odd.setOnClickListener(this);

        ButtonBackground();


        return view;
    }

    public void JumpFrag(String frag){
        switch (frag) {
            case "faces":
                getActivity().getFragmentManager().beginTransaction().add(R.id.frameLayout,FACES).commit();
                break;
            case "erc":
                getActivity().getFragmentManager().beginTransaction().add(R.id.frameLayout,ERC).commit();
                break;
            case "ders":
                getActivity().getFragmentManager().beginTransaction().add(R.id.frameLayout,DERS).commit();
                break;
            case "api":
                getActivity().getFragmentManager().beginTransaction().add(R.id.frameLayout,API).commit();
                break;
            case "odd":
                getActivity().getFragmentManager().beginTransaction().add(R.id.frameLayout,ODD).commit();
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fa:
                JumpFrag("faces");
                break;
            case R.id.erc:
                JumpFrag("erc");
                break;
            case R.id.ders:
                JumpFrag("ders");
                break;
            case R.id.api:
                JumpFrag("api");
                break;
            case R.id.odd:
                JumpFrag("odd");
                break;
            default:
                break;
        }
    }
}
