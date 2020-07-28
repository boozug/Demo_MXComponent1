package com.example.demo_mxcomponent1;

public class Plcs {
    private String mName;
    private int birthYear;

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public Plcs(String mName, int birthYear) {
        this.mName = mName;
        this.birthYear = birthYear;
    }

    public String getmName() {
        return mName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
