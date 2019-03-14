package com.ekoapp.ekoplayground.presentation.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.data.persistences.entities.Topic;
import com.ekoapp.ekoplayground.presentation.activities.adapters.TopicAdapter;
import com.ekoapp.ekoplayground.presentation.activities.intents.TopicIntent;
import com.ekoapp.ekoplayground.presentation.contracts.TopicContract;
import com.ekoapp.ekoplayground.presentation.presenters.TopicPresenter;
import com.ekoapp.ekoplayground.presentation.viewmodels.TopicViewModel;
import com.uber.autodispose.ScopeProvider;

import butterknife.BindView;

public class TopicActivity extends EkoActivity implements TopicContract {

    @BindView(R2.id.chat_recycler_view)
    RecyclerView chatList;

    private TopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TopicViewModel viewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        TopicPresenter presenter = new TopicPresenter(viewModel, this);
        presenter.test(TopicIntent.getChatId(getIntent()));
    }

    @Override
    public ScopeProvider getScopeProvider() {
        return this;
    }

    @Override
    public void setupList() {
        adapter = new TopicAdapter(this);
        chatList.setAdapter(adapter);
        chatList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void submitList(PagedList<Topic> list) {
        adapter.submitList(list);
    }
}
