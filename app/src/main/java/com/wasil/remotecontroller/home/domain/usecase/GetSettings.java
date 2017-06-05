package com.wasil.remotecontroller.home.domain.usecase;

import com.wasil.remotecontroller.UseCaseRx;
import com.wasil.remotecontroller.data.ChannelsDAO;
import com.wasil.remotecontroller.data.model.ChannelSettings;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomek on 25.05.17.
 */

public class GetSettings extends UseCaseRx<GetSettings.RequestValues,
        GetSettings.ResponseValues> {

    private ChannelsDAO channelsDAO;

    public GetSettings(ChannelsDAO channelsDAO) {
        super(Schedulers.io());
        this.channelsDAO = channelsDAO;
    }

    public GetSettings(ChannelsDAO channelsDAO, Scheduler backgroundScheduler) {
        super(backgroundScheduler);
        this.channelsDAO = channelsDAO;
    }


    @Override
    protected Observable<GetSettings.ResponseValues> executeUseCase(GetSettings.RequestValues requestValues) {

        return channelsDAO.getChannelsData().map(ResponseValues::new);
    }

    public static final class RequestValues implements UseCaseRx.RequestValues {

    }

    public static final class ResponseValues implements UseCaseRx.ResponseValues {

        List<ChannelSettings> channelsList;

        public ResponseValues(List<ChannelSettings> channelsList) {
            this.channelsList = channelsList;
        }

        public List<ChannelSettings> getChannelsList() {
            return channelsList;
        }

        public void setChannelsList(List<ChannelSettings> channelsList) {
            this.channelsList = channelsList;
        }
    }

}
