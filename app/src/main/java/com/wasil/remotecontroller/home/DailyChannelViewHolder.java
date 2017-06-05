package com.wasil.remotecontroller.home;

import android.view.View;
import android.widget.TextView;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.util.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by slomek on 31.05.17.
 */

public class DailyChannelViewHolder extends SimplyChannelViewHolder {

    @BindView(R.id.start_time)
    public TextView startTime;

    @BindView(R.id.end_time)
    public TextView endTime;

    public DailyChannelViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(OnItemClickListener<ChannelSettings> onItemClickListener, ChannelSettings channel) {
        super.bind(onItemClickListener, channel);
        startTime.setText(channel.getStartTimeInText());
        endTime.setText(channel.getEndTimeInText());
    }
}
