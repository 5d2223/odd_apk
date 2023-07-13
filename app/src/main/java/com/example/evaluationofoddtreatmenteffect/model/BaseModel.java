package com.example.evaluationofoddtreatmenteffect.model;

import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.precenter.callback;

public interface BaseModel {

//    创建数据库设置内容
    results SetDatabase();
//    获取已有数据库展示内容
    results ShowDatabase();

//    从网络请求数据成功回调接口方法
    void request(callback callback,String url,int length);
}
