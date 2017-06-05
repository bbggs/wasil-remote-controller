package com.wasil.remotecontroller.data;

import com.wasil.remotecontroller.data.model.ChannelSettings;

import java.util.List;

import rx.Observable;

/**
 * Created by slomek on 25.05.17.
 */

public interface ChannelsDAO {

    Observable<List<ChannelSettings>> getChannelsData();

    void setChannel(ChannelSettings channelSettings); // TODO: 25.05.17
}

