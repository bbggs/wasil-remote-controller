package com.wasil.remotecontroller.data;

import com.wasil.remotecontroller.data.model.ChannelMode;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.data.model.Time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by slomek on 29.05.17.
 */

public class RemoteChannelsDAO implements ChannelsDAO {

    private static RemoteChannelsDAO remoteChannelsDAO;

    private RemoteChannelsDAO() {
    }

    public static RemoteChannelsDAO getInstance(){
        return Handler.INSTANCE;
    }

    public static final class Handler{
        static final RemoteChannelsDAO INSTANCE = new RemoteChannelsDAO();
    }

    @Override
    public Observable<List<ChannelSettings>> getChannelsData() {
        return Observable.from(getTestChannels())
                .delay(1000, TimeUnit.MILLISECONDS) // TODO: 29.05.17 to delete
                .toList();
    }

    @Override
    public void setChannel(ChannelSettings channelSettings) {

    }


    public List<ChannelSettings> getTestChannels() {
        List<ChannelSettings> channelList = new ArrayList<>(0);
        for (int i = 1; i <= 4; i++) {
            channelList.add(new ChannelSettings(i, i % 2 == 0, i%2 == 0 ? ChannelMode.MANUAL
                    : ChannelMode.DAILY, new Time(9,7), new Time(13,55)));
        }
        return channelList;
    }
}
