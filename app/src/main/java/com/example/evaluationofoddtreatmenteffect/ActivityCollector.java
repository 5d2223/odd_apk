package com.example.evaluationofoddtreatmenteffect;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

//    活动收集器，便于活动的一次性销毁
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
