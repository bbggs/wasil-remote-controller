package com.wasil.remotecontroller.home;

import com.wasil.remotecontroller.BasePresenter;
import com.wasil.remotecontroller.BaseView;
import com.wasil.remotecontroller.channelsettings.ChannelSettingsFragment;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.util.OnItemClickListener;

import java.util.List;

/**
 * Created by slomek on 28.05.17.
 */

public interface HomeContract {

    interface View extends BaseView<HomeContract.Presenter> {
        void showMessageInSnackbar(String msg);

        void showChannels(List<ChannelSettings> channels);

        void showSaveSettingsDialog();

        void goToSettings(ChannelSettingsFragment settingsFragment);

        void showMsgOnError();

        void showMsgOnSucces();

        void setLoadingIndicator(boolean show);
    }

    interface Presenter extends BasePresenter, OnItemClickListener<ChannelSettings> {
        void saveSettings(String settingsName);

        void sendSettings();

        void load();

    }

}
