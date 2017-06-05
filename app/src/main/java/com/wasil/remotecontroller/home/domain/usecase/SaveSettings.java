package com.wasil.remotecontroller.home.domain.usecase;

import com.wasil.remotecontroller.UseCaseRx;
import com.wasil.remotecontroller.data.ChannelsDAO;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomek on 28.05.17.
 */

public class SaveSettings extends UseCaseRx<SaveSettings.RequestValues,SaveSettings.ResponseValue> {

    private ChannelsDAO channelsDAO;

    public SaveSettings(ChannelsDAO channelsDAO, Scheduler backgroundScheduler) {
        super(backgroundScheduler);
        this.channelsDAO = channelsDAO;
    }

    public SaveSettings(ChannelsDAO channelsDAO) {
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
