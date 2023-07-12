package com.example.evaluationofoddtreatmenteffect.precenter;

public interface BasePrecenter {
    void question(String url,int length);
    void WenjuanUpdate(int score,String wenjuan);

    void InformationUpdate(String inform,String type);
    void DatabaseShow();
    void sendEmail();

}
