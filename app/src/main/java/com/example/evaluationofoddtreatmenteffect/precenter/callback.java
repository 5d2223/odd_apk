package com.example.evaluationofoddtreatmenteffect.precenter;

public interface callback {
    <T>void onSuccess(T[] data,int length);

    void onFailure();
}
