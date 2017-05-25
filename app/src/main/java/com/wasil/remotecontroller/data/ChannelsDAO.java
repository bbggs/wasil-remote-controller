package com.wasil.remotecontroller.data;

import java.util.List;

import rx.Observable;

/**
 * Created by slomek on 25.05.17.
 */

public interface ChannelsDAO {

    Observable<List<ChannelMode>> getChannelsData();

    void setChannel(ChannelSettings channelSettings); // TODO: 25.05.17
}

