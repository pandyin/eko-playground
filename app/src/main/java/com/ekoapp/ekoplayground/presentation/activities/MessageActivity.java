package com.ekoapp.ekoplayground.presentation.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;
import com.ekoapp.ekoplayground.presentation.activities.adapters.MessageAdapter;
import com.ekoapp.ekoplayground.presentation.activities.intents.MessageIntent;
import com.ekoapp.ekoplayground.presentation.contracts.MessageContract;
import com.ekoapp.ekoplayground.presentation.presenters.MessagePresenter;
import com.ekoapp.ekoplayground.presentation.viewmodels.MessageViewModel;
import com.uber.autodispose.ScopeProvider;

import butterknife.BindView;

public class MessageActivity extends EkoActivity implements MessageContract {

    @BindView(R2.id.message_recycler_view)
    RecyclerView messageList;

    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        MessageViewModel viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        MessagePresenter presenter = new MessagePresenter(viewModel, this);
        presenter.test(MessageIntent.getTopicId(getIntent()));
    }

    @Override
    public ScopeProvider getScopeProvider() {
        return this;
    }

    @Override
    public void setupList() {
        adapter = new MessageAdapter(this);
        messageList.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        messageList.setLayoutManager(layoutManager);
    }

    @Override
    public void submitList(PagedList<Message> list) {
        adapter.submitList(list);
    }
}
