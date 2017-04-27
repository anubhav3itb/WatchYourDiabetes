package com.example.anubhavbhardwaj.watchyourdiabetes;

/**
 * Created by aditya on 24/4/17.
 */

public class Appointment {
    int id;
    String date;

    public Appointment(){

    }

    public Appointment(int id, String date){
        this.id = id;
        this.date = date;
    }

    public int getId(){
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDate(String date){
        this.date = date;
    }
}
