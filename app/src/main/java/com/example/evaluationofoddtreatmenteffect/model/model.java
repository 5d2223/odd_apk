package com.example.evaluationofoddtreatmenteffect.model;

import com.example.evaluationofoddtreatmenteffect.bean.results;

import org.json.JSONArray;
import org.json.JSONException;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.example.evaluationofoddtreatmenteffect.Presenter.callback;

import java.io.IOException;

public class model implements BaseModel{


    public results SetDatabase(){
        Connector.getDatabase();
        return new results();
    }

    @Override
    public results ShowDatabase() {
        Connector.getDatabase();
        return LitePal.find(com.example.evaluationofoddtreatmenteffect.bean.results.class,1);
    }

    public void request(final callback callback,String url,int length){

        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url("https://58da9292.r16.cpolar.top/files/"+url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String  data =response.body().string();
                JSONArray array = null;
                try {
                    array = new JSONArray(data);
                    String[] wen = new String[length];
                    for(int i=0;i<array.length();i++){
                        wen[i]=array.getString(i);
                    }
                    callback.onSuccess(wen,length);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

}
