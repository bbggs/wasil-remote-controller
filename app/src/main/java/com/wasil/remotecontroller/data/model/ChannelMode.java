package com.wasil.remotecontroller.data.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by slomek on 25.05.17.
 */

public class ChannelMode {
    public static final int DAILY = 0;
    public static final int TIMER = 1;
    public static final int MANUAL = 2;



    public static List<String> getModesList(){
        return new ArrayList<>(Arrays.asList("Daily", "Timer", "Manual"));
    }
}
