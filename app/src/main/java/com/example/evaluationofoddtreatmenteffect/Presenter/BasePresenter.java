package com.example.evaluationofoddtreatmenteffect.Presenter;

public interface BasePresenter {
//    发起网络请求调用特定url数据
    void question(String url,int length);

//    更新数据库中问卷得分
    void WenjuanUpdate(int score,String wenjuan);

//    更新数据库中存储的个人信息
    void InformationUpdate(String inform,String type);

//    展示数据库中存储的个人信息
    void DatabaseShow();

//    发送邮件
    void sendEmail();

}
