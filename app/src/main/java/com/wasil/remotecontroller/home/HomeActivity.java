package com.wasil.remotecontroller.home;

import android.os.Bundle;

import com.wasil.remotecontroller.BaseActivity;
import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.channelsettings.domain.usecase.SetChannelSetting;
import com.wasil.remotecontroller.data.ChannelsDAO;
import com.wasil.remotecontroller.data.RemoteChannelsDAO;
import com.wasil.remotecontroller.home.domain.usecase.GetSettings;
import com.wasil.remotecontroller.util.ActivityUtil;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ChannelsDAO channelsDAO = RemoteChannelsDAO.getInstance();

        HomeFragment homeFragment = new HomeFragment();
        new HomePresenter(homeFragment, new GetSettings(channelsDAO), new SetChannelSetting(channelsDAO));

        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),
                homeFragment, R.id.fragment_container);

    }
}
