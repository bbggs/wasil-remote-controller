package com.wasil.remotecontroller.util;

import android.view.View;

/**
 * Created by slomek on 28.05.17.
 */

public interface OnItemClickListener<T> {

    void onItemClick(T item, int position, View view);
}
