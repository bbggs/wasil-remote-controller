package com.wasil.remotecontroller.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.data.model.ChannelMode;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.util.OnItemClickListener;

import java.util.List;

/**
 * Created by slomek on 28.05.17.
 */

public class ChannelsAdapter extends RecyclerView.Adapter<SimplyChannelViewHolder> {

    private OnItemClickListener<ChannelSettings> onItemClickListener;
    private List<ChannelSettings> channelsList;

    public static final int TYPE_ITEM_MANUAL = 0;
    public static final int TYPE_ITEM_DAILY = 1;
    public static final int TYPE_ITEM_TIMER = 2;

    public ChannelsAdapter(OnItemClickListener<ChannelSettings> onItemClickListener, List<ChannelSettings> channelsList) {
        this.onItemClickListener = onItemClickListener;
        this.channelsList = channelsList;
    }


    @Override
    public SimplyChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_ITEM_DAILY) {
            return new DailyChannelViewHolder(inflater
                    .inflate(R.layout.item_channel_daily, parent, false));
        } else if (viewType == TYPE_ITEM_TIMER) {
            return new TimerChannelViewHolder(inflater
                    .inflate(R.layout.item_channel_timer, parent, false));
        } else {
            return new SimplyChannelViewHolder(inflater
                    .inflate(R.layout.item_channel_simply, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(SimplyChannelViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM_DAILY) {
            ((DailyChannelViewHolder) holder).bind(onItemClickListener, channelsList.get(position));
        } else if (getItemViewType(position) == TYPE_ITEM_TIMER) {
            ((TimerChannelViewHolder) holder).bind(onItemClickListener, channelsList.get(position));
        } else {
            holder.bind(onItemClickListener, channelsList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (channelsList.get(position).getModeId() == ChannelMode.DAILY) {
            return TYPE_ITEM_DAILY;
        } else if (channelsList.get(position).getModeId() == ChannelMode.TIMER) {
            return TYPE_ITEM_TIMER;
        }
        return TYPE_ITEM_MANUAL;
    }

    @Override
    public int getItemCount() {
        return channelsList.size();
    }

    public List<ChannelSettings> getChannelsList() {
        return channelsList;
    }

    public void setChannelsList(List<ChannelSettings> channelsList) {
        this.channelsList = channelsList;
    }

    public OnItemClickListener<ChannelSettings> getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener<ChannelSettings> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
