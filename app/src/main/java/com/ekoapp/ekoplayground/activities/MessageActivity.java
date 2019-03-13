package com.ekoapp.ekoplayground.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.activities.adapters.MessageAdapter;
import com.ekoapp.ekoplayground.activities.intents.MessageListIntent;
import com.ekoapp.ekoplayground.contract.MessageContract;
import com.ekoapp.ekoplayground.presenters.MessagePresenter;
import com.ekoapp.ekoplayground.room.entities.Message;
import com.ekoapp.ekoplayground.viewmodels.MessageViewModel;
import com.uber.autodispose.ScopeProvider;

import butterknife.BindView;

public class MessageActivity extends EkoActivity implements MessageContract {

    @BindView(R2.id.message_recycler_view)
    RecyclerView messageList;

    private MessagePresenter presenter;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        MessageViewModel viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        presenter = new MessagePresenter(viewModel, this);
        presenter.test(MessageListIntent.getTopicId(getIntent()));
    }

    @Override
    public ScopeProvider getScopeProvider() {
        return this;
    }

    @Override
    public void setupList() {
        adapter = new MessageAdapter(this);
        messageList.setAdapter(adapter);
        messageList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void submitList(PagedList<Message> list) {
        adapter.submitList(list);
    }
}
