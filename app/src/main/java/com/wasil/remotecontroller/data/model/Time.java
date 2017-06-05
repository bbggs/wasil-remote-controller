package com.wasil.remotecontroller.data.model;

/**
 * Created by slomek on 02.06.17.
 */

public class Time {
    private int minutes;
    private int hours;
    private int seconds;

    public Time(int minutes, int hours, int seconds) {
        this.minutes = minutes;
        this.hours = hours;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.minutes = minutes;
        this.hours = hours;
        this.seconds = 0;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
