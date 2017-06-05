package com.wasil.remotecontroller.channelsettings;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.data.model.ChannelMode;
import com.wasil.remotecontroller.data.model.Time;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by slomek on 31.05.17.
 */

public class ChannelSettingsFragment extends DialogFragment implements ChannelSettingsContract.View {


    @BindView(R.id.mode_spinner)
    Spinner modeSpinner;

    @BindView(R.id.time_picker1)
    TimePicker timePicker1;

    @BindView(R.id.time_picker2)
    TimePicker timePicker2;

    @BindView(R.id.label_time_picker1)
    TextView label1;

    @BindView(R.id.label_time_picker2)
    TextView label2;

    @BindView(R.id.time_pickers)
    RelativeLayout timePickers;

    @BindView(R.id.save_button)
    Button saveButtob;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ChannelSettingsContract.Presenter presenter;
    private ArrayAdapter<String> modeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_settings, container);
        ButterKnife.bind(this, view);

        modeSpinner.setOnItemSelectedListener(presenter);
        progressBar.setVisibility(View.GONE);

        return view;
    }

    @Override()
    public void setPresenter(ChannelSettingsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showModeSpinner(int mode) {
        modeAdapter = new ArrayAdapter<>(this.getContext(),
                android.R.layout.simple_spinner_item, ChannelMode.getModesList());
        modeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        modeSpinner.setAdapter(modeAdapter);
        modeSpinner.setSelection(mode);


    }

    @Override
    public void setTimePickers(Time firstSetTime, Time secondSetTime) {
        timePicker1.setIs24HourView(true);
        timePicker2.setIs24HourView(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            timePicker1.setHour(firstSetTime.getHours());
            timePicker2.setHour(secondSetTime.getHours());

        }else {
            timePicker1.setCurrentHour(firstSetTime.getHours());
            timePicker2.setCurrentMinute(secondSetTime.getMinutes());

        }
    }

    @Override
    public void setDailyLabels() {
        label1.setText("od");
        label2.setText("do:");
    }

    @Override
    public void setTimerLabels() {
        label1.setText("pozostało:");
        label2.setText("czas uruchomienia");
    }

    @Override
    public void showTimePickers(boolean show) {
        timePickers.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    @Override
    public void showLoadingIndicator(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @OnClick(R.id.save_button)
    void onSaveClick(View v) {
        presenter.save();
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unsubscribe();
    }
}
