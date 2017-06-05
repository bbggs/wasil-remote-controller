package com.wasil.remotecontroller.home;

import android.view.View;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.channelsettings.ChannelSettingsFragment;
import com.wasil.remotecontroller.channelsettings.ChannelSettingsPresenter;
import com.wasil.remotecontroller.channelsettings.domain.usecase.SetChannelSetting;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.home.domain.usecase.GetSettings;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by slomek on 29.05.17.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private GetSettings getSettings;
    private SetChannelSetting setChannelSetting;
    private List<ChannelSettings> channelList;

    private final CompositeSubscription subscriptions;

    public HomePresenter(HomeContract.View view, GetSettings getSettings, SetChannelSetting setChannelSetting) {
        this.view = view;
        this.getSettings = getSettings;
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

    @Override
    public void saveSettings(String settingsName) {

    }

    @Override
    public void sendSettings() {

    }

    @Override
    public void load() {
        view.setLoadingIndicator(true);
        Subscription subscription = getSettings.execute(new GetSettings.RequestValues())
                .subscribe(new Observer<GetSettings.ResponseValues>() {
                    @Override
                    public void onCompleted() {
                        view.showMsgOnSucces();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showMsgOnError();
                    }

                    @Override
                    public void onNext(GetSettings.ResponseValues response) {
                        view.setLoadingIndicator(false);
                        view.showChannels(response.getChannelsList());
                    }
                });
        subscriptions.add(subscription);
    }

    @Override
    public void onItemClick(ChannelSettings item, int position, View clickedView) {
        if(clickedView.getId() == R.id.settings_button){
            ChannelSettingsFragment settingsFragment = new ChannelSettingsFragment();
            ChannelSettingsPresenter settingsPresenter = new ChannelSettingsPresenter(settingsFragment, item, setChannelSetting);

            this.view.goToSettings(settingsFragment);
        }
    }
}
