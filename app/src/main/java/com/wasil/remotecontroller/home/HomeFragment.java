package com.wasil.remotecontroller.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wasil.remotecontroller.R;
import com.wasil.remotecontroller.channelsettings.ChannelSettingsFragment;
import com.wasil.remotecontroller.data.model.ChannelSettings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by slomek on 28.05.17.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    @BindView(R.id.channel_list)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private HomeContract.Presenter presenter;
    private ChannelsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ChannelsAdapter(presenter, new ArrayList<>(0));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(() -> presenter.load());

        return view;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessageInSnackbar(String msg) {
        if (getView() != null) {
            Snackbar.make(getView(), msg, Snackbar.LENGTH_LONG);
        }
    }

    @Override
    public void showChannels(List<ChannelSettings> channels) {
        adapter.setChannelsList(channels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSaveSettingsDialog() {

    }

    @Override
    public void goToSettings(ChannelSettingsFragment settingsFragment) {
        settingsFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void showMsgOnError() {
        showMessageInSnackbar(getString(R.string.download_error));
    }

    @Override
    public void showMsgOnSucces() {
        showMessageInSnackbar(getString(R.string.download_succes));
    }

    @Override
    public void setLoadingIndicator(final boolean show) {
        if (getView() != null) {
            swipeRefreshLayout.post(() -> swipeRefreshLayout.setRefreshing(show));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}
