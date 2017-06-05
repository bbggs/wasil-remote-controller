package com.wasil.remotecontroller.home.domain.usecase;

import com.wasil.remotecontroller.UseCaseRx;
import com.wasil.remotecontroller.data.ChannelsDAO;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomek on 28.05.17.
 */

public class SendSettings extends UseCaseRx<SendSettings.RequestValues, SendSettings.ResponseValue>{

    private ChannelsDAO channelsDAO;

    public SendSettings(ChannelsDAO channelsDAO, Scheduler backgroundScheduler) {
        super(backgroundScheduler);
        this.channelsDAO = channelsDAO;
    }

    public SendSettings(ChannelsDAO channelsDAO) {
        super(Schedulers.io());
        this.channelsDAO = channelsDAO;
    }

    @Override
    protected Observable<ResponseValue> executeUseCase(RequestValues requestValues) {
        return null;
    }


    public class RequestValues implements UseCaseRx.RequestValues {
    }

    public class ResponseValue implements UseCaseRx.ResponseValues {
    }

}
