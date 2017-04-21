package com.example.anubhavbhardwaj.watchyourdiabetes;

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
        return id;
    }

    int getWeight(){
        return weight;
    }

    int getHeight(){
        return height;
    }

    int getFastingBloodSugar(){
        return fastingBloodSugar;
    }

    int getPostLunchBloodSugar(){
        return postLunchBloodSugar;
    }

    int getHba1c(){
        return hba1c;
    }
}
