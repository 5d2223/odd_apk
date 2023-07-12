package com.example.evaluationofoddtreatmenteffect.bean;

import org.litepal.crud.LitePalSupport;

public class results extends LitePalSupport {

    private int ODD;
    private int FACES;
    private int API;
    private int DRES;
    private int ERC;

    private String phone;
    private String mail;
    private String wechat;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getODD() {
        return ODD;
    }

    public void setODD(int ODD) {
        this.ODD = ODD;
    }

    public int getFACES() {
        return FACES;
    }

    public void setFACES(int FACES) {
        this.FACES = FACES;
    }

    public int getAPI() {
        return API;
    }

    public void setAPI(int API) {
        this.API = API;
    }

    public int getDRES() {
        return DRES;
    }

    public void setDRES(int DRES) {
        this.DRES = DRES;
    }

    public int getERC() {
        return ERC;
    }

    public void setERC(int ERC) {
        this.ERC = ERC;
    }
}
