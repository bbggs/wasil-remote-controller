package com.wasil.remotecontroller.channelsettings;

import android.view.View;
import android.widget.AdapterView;

import com.wasil.remotecontroller.channelsettings.domain.usecase.SetChannelSetting;
import com.wasil.remotecontroller.data.model.ChannelMode;
import com.wasil.remotecontroller.data.model.ChannelSettings;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by slomek on 31.05.17.
 */

public class ChannelSettingsPresenter implements ChannelSettingsContract.Presenter {

    private ChannelSettings channel;
    private ChannelSettingsContract.View view;
    private SetChannelSetting setChannelSetting;
    private CompositeSubscription subscriptions;

    public ChannelSettingsPresenter(ChannelSettingsContract.View view, ChannelSettings channel, SetChannelSetting setChannelSetting) {
        this.channel = channel;
        this.view = view;
        this.setChannelSetting = setChannelSetting;
        view.setPresenter(this);

        subscriptions = new CompositeSubscription();
    }

    @Override
    public void start() {
        load();
    }

    @Override
    public void unsubscribe() {
        subscriptions.unsubscribe();
    }

    public void load() {

        view.showModeSpinner(channel.getModeId());


        switch (channel.getModeId()) {
            case ChannelMode.DAILY : loadDailyMode();
                break;
            case ChannelMode.TIMER : loadTimerMode();
                break;
            default : loadManualMode();
        }

    }

    @Override
    public void loadManualMode() {
        view.showTimePickers(false);

    }

    private void loadTimePickers(){
        view.showTimePickers(true);
        view.setTimePickers(channel.getStartTime(), channel.getEndTime());
    }

    @Override
    public void loadDailyMode() {
        loadTimePickers();
        view.setDailyLabels();
    }

    @Override
    public void loadTimerMode() {
        loadTimePickers();
        view.setTimerLabels();
    }

    @Override
    public void save() {
        view.showLoadingIndicator(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        channel.setModeId(position);
        load();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
