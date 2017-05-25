package com.wasil.remotecontroller;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by slomek on 25.05.17.
 */

public abstract class UseCaseRx<Q extends UseCaseRx.RequestValues, P extends UseCaseRx.ResponseValues> {

    private final Scheduler backgroundScheduler;

    public UseCaseRx(Scheduler backgroundScheduler) {
        this.backgroundScheduler = backgroundScheduler;
    }

    protected abstract Observable<P> executeUseCase(Q requestValues);

    public Observable<P> execute(Q requestValues) {
        return executeUseCase(requestValues)
                .subscribeOn(backgroundScheduler)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface RequestValues {
    }

    public interface ResponseValues {
    }
}
