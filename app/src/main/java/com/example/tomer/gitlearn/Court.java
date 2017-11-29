package com.example.tomer.gitlearn;

/**
 * Created by Tomer on 26/11/2017.
 */

public class Court {
    String NAMEHEB,NAMEENG;
    public Court(String nameheb, String nameen){
        this.NAMEHEB = nameheb;
        this.NAMEENG = nameen;
    }

    public String getNAMEHEB() {
        return NAMEHEB;
    }

    public void setNAMEHEB(String NAMEHEB) {
        this.NAMEHEB = NAMEHEB;
    }

    public String getNAMEENG() {
        return NAMEENG;
    }

    public void setNAMEENG(String NAMEENG) {
        this.NAMEENG = NAMEENG;
    }
}
