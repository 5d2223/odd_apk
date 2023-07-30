package com.example.evaluationofoddtreatmenteffect.bean;

//问卷介绍单个item展示内容基类
public class jieshao {
    private String jieshao;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;

    public jieshao(String jieshao, String img) {
        this.jieshao = jieshao;
        this.img = img;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }
}
