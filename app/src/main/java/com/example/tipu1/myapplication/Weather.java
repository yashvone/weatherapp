package com.example.tipu1.myapplication;

/**
 * Created by tipu1 on 3/21/2018.
 */

public class Weather {
    String date;
    String minTemp;
    String maxTemp;
    String first;
    String second;

    public String getFirst() { return first;}

    public String getSecond() { return second;}

    public void setFirst(String first) { this.first = first;}

    public void setSecond(String second) { this.second = second;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

}
