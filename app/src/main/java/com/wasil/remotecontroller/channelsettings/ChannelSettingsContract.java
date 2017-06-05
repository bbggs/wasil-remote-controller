package com.wasil.remotecontroller.channelsettings;

import android.widget.AdapterView;

import com.wasil.remotecontroller.BasePresenter;
import com.wasil.remotecontroller.BaseView;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.data.model.Time;

import java.util.Calendar;

/**
 * Created by slomek on 31.05.17.
 */

public interface ChannelSettingsContract {
    interface View extends BaseView<Presenter> {

        void showModeSpinner(int mode);

        void setTimePickers(Time firstSetTime, Time secondSetTime);

        void setDailyLabels();

        void setTimerLabels();

        void showTimePickers(boolean show);

        void showLoadingIndicator(boolean show);

    }

    interface Presenter extends BasePresenter, AdapterView.OnItemSelectedListener {
        void save();

        void load();

        void loadManualMode();

        void loadDailyMode();

        void loadTimerMode();


    }

}
