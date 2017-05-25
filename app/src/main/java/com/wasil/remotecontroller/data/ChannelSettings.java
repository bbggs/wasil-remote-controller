package com.wasil.remotecontroller.data;

import java.util.Date;

/**
 * Created by slomek on 25.05.17.
 */

public abstract class ChannelSettings {

    private Date startTime;
    private Date endTime;
    private boolean isActive;
    private int canalId;
    private ChannelMode mode;

    public ChannelSettings(int canalId, ChannelMode mode, Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.canalId = canalId;
        this.mode = mode;
        isActive = true;
    }

    public ChannelSettings(int canalId, ChannelMode mode) {
        this.canalId = canalId;
        this.mode = mode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
}
