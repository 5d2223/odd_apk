package com.example.evaluationofoddtreatmenteffect.model;

import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.precenter.callback;

public interface BaseModel {
    results SetDatabase();
    results ShowDatabase();
    void request(callback callback,String url,int length);
}
