package com.ekoapp.ekoplayground.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.activities.adapters.TopicAdapter;
import com.ekoapp.ekoplayground.activities.intents.TopicIntent;
import com.ekoapp.ekoplayground.viewmodels.TopicViewModel;
import com.uber.autodispose.AutoDispose;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopicActivity extends EkoActivity {

    @BindView(R2.id.chat_recycler_view)
    RecyclerView chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TopicViewModel viewModel = ViewModelProviders.of(this)
                .get(TopicViewModel.class);

        TopicAdapter adapter = new TopicAdapter(this);
        chatList.setAdapter(adapter);
        chatList.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getTopic(TopicIntent.getChatId(getIntent()))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(adapter::submitList)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(this))
                .subscribe();
    }
}
