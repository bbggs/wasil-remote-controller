package com.wasil.remotecontroller.home.domain.usecase;

import com.wasil.remotecontroller.UseCaseRx;
import com.wasil.remotecontroller.data.ChannelsDAO;
import com.wasil.remotecontroller.data.ChannelMode;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomek on 25.05.17.
 */

public class GetChannelsSettings extends UseCaseRx<GetChannelsSettings.RequestValues,
        GetChannelsSettings.ResponseValues> {

    private ChannelsDAO channelsDAO;

    public GetChannelsSettings(ChannelsDAO channelsDAO) {
        super(Schedulers.io());
        this.channelsDAO = channelsDAO;
    }

    public GetChannelsSettings(ChannelsDAO channelsDAO, Scheduler backgroundScheduler) {
        super(backgroundScheduler);
        this.channelsDAO = channelsDAO;
    }


    @Override
    protected Observable<GetChannelsSettings.ResponseValues> executeUseCase(GetChannelsSettings.RequestValues requestValues) {

        return channelsDAO.getChannelsData().map(ResponseValues::new);
    }

    public class RequestValues implements UseCaseRx.RequestValues {

    }

    public class ResponseValues implements UseCaseRx.ResponseValues {

        List<ChannelMode> channelModes;

        public ResponseValues(List<ChannelMode> channelModes) {
            this.channelModes = channelModes;
        }

        public List<ChannelMode> getChannelModes() {
            return channelModes;
        }

        public void setChannelModes(List<ChannelMode> channelModes) {
            this.channelModes = channelModes;
        }
    }

}
