package com.wasil.remotecontroller.channelsettings.domain.usecase;

import com.wasil.remotecontroller.UseCaseRx;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.data.ChannelsDAO;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomek on 25.05.17.
 */

public class SetChannelSetting extends UseCaseRx<SetChannelSetting.RequestValues,
        SetChannelSetting.ResponseValues> {

    private ChannelsDAO channelsDAO;

    public SetChannelSetting(ChannelsDAO channelsDAO, Scheduler backgroundScheduler) {
        super(backgroundScheduler);
        this.channelsDAO = channelsDAO;
    }

    public SetChannelSetting(ChannelsDAO channelsDAO) {
        super(Schedulers.io());
        this.channelsDAO = channelsDAO;
    }

    @Override
    protected Observable<ResponseValues> executeUseCase(RequestValues requestValues) {
        return Observable.create((subscriber) ->{
            channelsDAO.setChannel(requestValues.getChannelSettings());
            subscriber.onCompleted();
                }
        );  
    }

    public static final class RequestValues implements UseCaseRx.RequestValues {

        ChannelSettings channelSettings;

        public RequestValues(ChannelSettings channelSettings) {
            this.channelSettings = channelSettings;
        }

        public ChannelSettings getChannelSettings() {
            return channelSettings;
        }

        public void setChannelSettings(ChannelSettings channelSettings) {
            this.channelSettings = channelSettings;
        }
    }

    public static final class ResponseValues implements UseCaseRx.ResponseValues {

    }
}
