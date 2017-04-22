package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.util.Log;

/**
 * Created by anubhavbhardwaj on 21/04/2017.
 */

public class MutableUserData {
    int id;
    int weight;
    int height;
    int fastingBloodSugar;
    int postLunchBloodSugar;
    int hba1c;

    public MutableUserData(){

    }

    public MutableUserData(int id, int weight, int height, int fastingBloodSugar, int postLunchBloodSugar, int hba1c){
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.fastingBloodSugar = fastingBloodSugar;
        this.postLunchBloodSugar = postLunchBloodSugar;
        this.hba1c = hba1c;
    }

    int getId(){
        return this.id;
    }

    int getWeight(){
        return this.weight;
    }

    int getHeight(){
        return this.height;
    }

    int getFastingBloodSugar(){
        return this.fastingBloodSugar;
    }

    int getPostLunchBloodSugar(){
        return this.postLunchBloodSugar;
    }

    int getHba1c(){
        return this.hba1c;
    }
}
