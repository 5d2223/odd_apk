package com.example.evaluationofoddtreatmenteffect.Presenter;

public interface callback {
    <T>void onSuccess(T[] data,int length);

    void onFailure();
}
