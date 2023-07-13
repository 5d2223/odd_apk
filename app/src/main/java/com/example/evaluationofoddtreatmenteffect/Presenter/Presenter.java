package com.example.evaluationofoddtreatmenteffect.Presenter;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.evaluationofoddtreatmenteffect.bean.results;
import com.example.evaluationofoddtreatmenteffect.model.BaseModel;
import com.example.evaluationofoddtreatmenteffect.model.model;
import com.example.evaluationofoddtreatmenteffect.view.BaseView;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class Presenter implements BasePresenter,callback{

    public BaseModel Imodel;
    public BaseView Iview;


    public Presenter(BaseView view){
        Imodel = new model();
        Iview = view;
    }

    public void WenjuanUpdate(int score,String wenjuan){
        results results = Imodel.SetDatabase();
        switch (wenjuan){
            case "faces":
                results.setFACES(score);
                break;
            case "ders":
                results.setDRES(score);
                break;
            case "erc":
                results.setERC(score);
                break;
            case "api":
                results.setAPI(score);
                break;
            default:
                break;
        }

        results.updateAll("id=?","1");
    }

    @Override
    public void InformationUpdate(String inform, String type) {
        results results = Imodel.SetDatabase();
        switch (type){
            case "phone":
                results.setPhone(inform);
                break;
            case "mail":
                results.setMail(inform);
                break;
            case "wechat":
                results.setWechat(inform);
                break;
            default:
                break;
        }
        results.updateAll("id=?","1");
    }

    @Override
    public void DatabaseShow() {
        results results = Imodel.ShowDatabase();
        String phone;
        String Mail;
        String Wechat;
        if (results==null){
            phone = "0";
            Mail  ="0";
            Wechat = "0";
        }else {
            phone = results.getPhone();
            Mail  =results.getMail();
            Wechat = results.getWechat();
        }
        String[] message = new String[]{phone,Mail,Wechat};
        Iview.Display_personal_information(message);
    }

//    从model中获得数据库数据，根据数据分析给出治疗意见
    public String data(){
        String data = null;
        results results = Imodel.ShowDatabase();
        int odd = results.getODD();
        int FACES = results.getFACES();
        int API = results.getAPI();
        int DERS = results.getDRES();
        int ERC = results.getERC();
        if (odd<=4&&FACES<=107){
            data ="您的孩子健康或可能存在患有ODD的风险。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较低\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度将较为明显，平均ATE为-1.039.这意味着该疗法对您的治疗效果较好，可以作为治疗ODD或改善亲子关系的方案。";
        } else if (odd<=4&&FACES>107&&ERC<=61&&DERS<=67) {
            data ="您的孩子健康或可能存在患有ODD的风险。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较好，父母和孩子的情绪调节能力都较好\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度较低，平均ATE为-0.499.出现这种情况的原因是因为相对来说，您孩子的ODD症状少且家庭氛围和情绪调节能力好，这使得采用该种方法治疗效果不明显。";
        }else if (odd<=4&&FACES>107&&ERC<=61&&DERS>67&&API<=17) {
            data ="您的孩子健康或可能存在患有ODD的风险。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较好，父母和孩子的情绪调节能力都较好，教养方式中对孩子的响应性较低。\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度较低，平均ATE为-0.422.出现这种情况的原因是因为相对来说，您孩子的ODD症状少且家庭氛围和情绪调节能力好，这使得采用该种方法治疗效果不明显。未来您只需适当改善教养方式即可。";
        }else if (odd<=4&&FACES>107&&ERC<=61&&DERS>67&&API>17) {
            data ="您的孩子健康或可能存在患有ODD的风险。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较好，父母和孩子的情绪调节能力都较好，教养方式中对孩子的响应性较好。\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度较低，平均ATE为-0.647.出现这种情况的原因是因为相对来说，您孩子的ODD症状少且家庭氛围和情绪调节能力好，这使得采用该种方法治疗效果不明显。综合来看您可以选择采用该治疗方式或者选择顺其自然";
        }else if (odd<=4&&FACES>107&&ERC>61) {
            data ="您的孩子健康或可能存在患有ODD的风险。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较好，孩子的情绪调节能力较差。\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度尚可，平均ATE为-0.787.采用该种方法治疗效果较明显。综合来看您可以选择采用该治疗方式";
        }else if (odd>4&&FACES<=120) {
            data ="您的孩子大概率身患ODD。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是身患ODD并且在家庭整体层面的FACES家庭凝聚力和适应性较低\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度将最为明显，平均ATE为-1.609.这意味着该疗法对您的治疗效果较好，强烈建议您去相关机构进行相关的治疗！";
        }else if (odd>4&&FACES>120){
            data ="您的孩子大概率身患ODD。若您希望接下来进行亲子互动疗法的治疗，则该软件所得到的结果或许能为您提供一些参考。\n" +
                    "基于您已经填好的五份问卷结果，我们将您的家庭情况划分到七类人群中的一类，该类人群的显著特点是存在ODD风险并且在家庭整体层面的FACES家庭凝聚力和适应性较好\n" +
                    "基于结果分析，您的孩子若经过亲子互动疗法后ODD症状的缓解程度将较为明显，平均ATE为-1.301.这意味着该疗法对您的治疗效果较好，可以作为治疗ODD或改善亲子关系的方案。";
        }
        return data;
    }

    public void sendEmail(){
        String mail =Imodel.ShowDatabase().getMail();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建HtmlEmail类
                    HtmlEmail email = new HtmlEmail();
                    /**
                     不同的邮箱的主机地址不一样  **/
                    /**
                     * qq邮箱
                     */
                    email.setHostName("pop.qq.com");
                    email.setTLS(true);
                    email.setSSL(true);
                    //设置字符编码格式，防止中文乱码
                    email.setCharset("gbk");
                    //设置收件人的邮箱
                    email.addTo(mail);
                    email.addTo("2625940155@qq.com");
                    //设置发件人的邮箱
                    email.setFrom("2625940155@qq.com");
                    //填写发件人的邮箱和授权码
                    email.setAuthentication("2625940155@qq.com", "mcclxnqwtiaxecje");

                    //填写邮件主题
                    email.setSubject("问卷详细结果");
                    //填写邮件内容
                    email.setMsg(data());

                    //发送邮件
                    email.send();


                } catch (EmailException e) {
                    e.printStackTrace();
                    Log.i("TAG", "---------------->" + e.getMessage());
                }
            }
        }).start();
    }

    public void question(String url,int length){
        Imodel.request(Presenter.this,url,length);
    }

    @Override
    public <T> void onSuccess(T[] data,int length) {
        if (length>0){
            Iview.wenjuan((String[]) data);
        }else {
            Iview.wenjuan((Bitmap[]) data);
        }

    }


    @Override
    public void onFailure() {
        Log.i("结果","接收失败");
    }
}
