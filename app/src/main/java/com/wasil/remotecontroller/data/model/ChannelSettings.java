package com.wasil.remotecontroller.data.model;

import java.util.Locale;

/**
 * Created by slomek on 25.05.17.
 */

public class ChannelSettings {

    private Time startTime;
    private Time endTime;
    private boolean isActive;
    private int canalId;
    private int modeId;

    public ChannelSettings(int canalId, boolean isActive, int modeId, Time startTime, Time endTime) {
        this.isActive = isActive;
        this.startTime = startTime;
        this.endTime = endTime;
        this.canalId = canalId;
        this.modeId = modeId;
    }

    public ChannelSettings(int canalId, boolean isActive, int modeId) {
        this.isActive = isActive;
        this.canalId = canalId;
        this.modeId = modeId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCanalId() {
        return canalId;
    }

    public void setCanalId(int canalId) {
        this.canalId = canalId;
    }

    public String getStartTimeInText() {
        return getTimeInText(startTime);
    }

    public String getEndTimeInText() {
        return getTimeInText(endTime);
    }

    private String getTimeInText(Time time) {
        return String.format(Locale.US, "%02d : %02d", time.getHours(),
                time.getMinutes());
    }

    public int getModeId() {
        return modeId;
    }

    public void setModeId(int modeId) {
        this.modeId = modeId;
    }
}
