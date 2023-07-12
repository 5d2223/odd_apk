package com.example.evaluationofoddtreatmenteffect.model;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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

import com.example.evaluationofoddtreatmenteffect.precenter.callback;

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
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    OkHttpClient client = new OkHttpClient();
//                    Request request =new Request.Builder().url("https://5305ddf2.r16.cpolar.top/files/"+url)
//                            .build();
//                    Response response = client.newCall(request).execute();
//                    String  data =response.body().string();
//                    JSONArray array = new JSONArray(data);
//                    String[] wen = new String[length];
//                    for(int i=0;i<array.length();i++){
//                        wen[i]=array.getString(i);
//                    }
//                    callback.onSuccess(wen);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    callback.onFailure();
//                }
//            }
//        }).start();

        try {
            OkHttpClient client = new OkHttpClient();
            Request request =new Request.Builder().url("https://5305ddf2.r16.cpolar.top/files/"+url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(length!=0){
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
                    }else {
                        Bitmap[] Map = new Bitmap[1];
                        Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                        Map[0]=bitmap;
                        callback.onSuccess(Map,length);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            callback.onFailure();
        }

    }

}
