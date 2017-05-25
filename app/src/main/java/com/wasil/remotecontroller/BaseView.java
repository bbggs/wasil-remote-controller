package com.wasil.remotecontroller;

/**
 * Created by slomek on 25.05.17.
 */

public interface BaseView<T extends  BasePresenter> {
    void setPresenter(T presenter);
}
