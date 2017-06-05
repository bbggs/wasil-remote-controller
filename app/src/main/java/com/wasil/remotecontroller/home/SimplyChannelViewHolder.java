package com.wasil.remotecontroller.home;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.data.model.ChannelMode;
import com.wasil.remotecontroller.data.model.ChannelSettings;
import com.wasil.remotecontroller.util.OnItemClickListener;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by slomek on 28.05.17.
 */

public class SimplyChannelViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener<ChannelSettings> onItemClickListener;
    private ChannelSettings channel;

    @BindView(R.id.channel_number)
    public TextView channelTitle;

    @BindView(R.id.activity_indicator)
    public ImageButton activityIndicator;

    @BindView(R.id.mode)
    public TextView mode;

    public SimplyChannelViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(OnItemClickListener<ChannelSettings> onItemClickListener,
                     ChannelSettings channel) {
        this.onItemClickListener = onItemClickListener;
        this.channel = channel;
        Context context = itemView.getContext();
        channelTitle.setText(String.format(Locale.US,
                context.getString(R.string.channel_number), channel.getCanalId()));
        Drawable indicatorCircle = ContextCompat.getDrawable(context, R.drawable.circle);
        indicatorCircle.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context, channel.isActive()
                ? R.color.colorActive
                : R.color.colorDisactive), PorterDuff.Mode.SRC));
        activityIndicator.setBackground(indicatorCircle);
        mode.setText(ChannelMode.getModesList().get(channel.getModeId()));
    }

    @OnClick({R.id.settings_button, R.id.activity_indicator})
    public void onClick(View view) {
        onItemClickListener.onItemClick(channel, getAdapterPosition(), view);
    }


}
