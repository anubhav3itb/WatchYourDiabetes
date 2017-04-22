package com.example.anubhavbhardwaj.watchyourdiabetes;

/**
 * Created by aditya on 23/4/17.
 */

public class Prescription {
    int id;
    String medicine1; int dosage1;
    String medicine2; int dosage2;
    String medicine3; int dosage3;

    public Prescription(){

    }

    public Prescription(int id, String medicine1, int dosage1, String medicine2, int dosage2,
                        String medicine3, int dosage3){
        this.id = id;

        this.medicine1 = medicine1;
        this.medicine2 = medicine2;
        this.medicine3 = medicine3;

        this.dosage1 = dosage1;
        this.dosage2 = dosage2;
        this.dosage3 = dosage3;
    }

    // get
    public int getId() {
        return id;
    }

    public int getDosage1() {
        return dosage1;
    }

    public int getDosage2() {
        return dosage2;
    }

    public int getDosage3() {
        return dosage3;
    }

    public String getMedicine1() {
        return medicine1;
    }

    public String getMedicine2() {
        return medicine2;
    }

    public String getMedicine3() {
        return medicine3;
    }

    // set
    public void setId(int id) {
        this.id = id;
    }

    public void setDosage1(int dosage1) {
        this.dosage1 = dosage1;
    }

    public void setDosage2(int dosage2) {
        this.dosage2 = dosage2;
    }

    public void setDosage3(int dosage3) {
        this.dosage3 = dosage3;
    }

    public void setMedicine1(String medicine1) {
        this.medicine1 = medicine1;
    }

    public void setMedicine2(String medicine2) {
        this.medicine2 = medicine2;
    }

    public void setMedicine3(String medicine3) {
        this.medicine3 = medicine3;
    }
}
