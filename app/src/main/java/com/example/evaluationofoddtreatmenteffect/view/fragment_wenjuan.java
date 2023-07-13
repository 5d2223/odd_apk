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


public class fragment_wenjuan extends Fragment implements View.OnClickListener{

    public Button faces,erc,ders,api,odd;
    public TextView show;

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
        faces =view.findViewById(R.id.fa);
        erc = view.findViewById(R.id.erc);
        ders = view.findViewById(R.id.ders);
        api = view.findViewById(R.id.api);
        odd = view.findViewById(R.id.odd);
        show = view.findViewById(R.id.show);

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
                fragment_FACES faces = new fragment_FACES();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,faces).commit();
                break;
            case "erc":
                fragment_ERC erc = new fragment_ERC();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,erc).commit();
                break;
            case "ders":
                fragment_DERS ders = new fragment_DERS();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,ders).commit();
                break;
            case "api":
                fragment_API api = new fragment_API();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,api).commit();
                break;
            case "odd":
                fragment_ODD odd = new fragment_ODD();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,odd).commit();
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
