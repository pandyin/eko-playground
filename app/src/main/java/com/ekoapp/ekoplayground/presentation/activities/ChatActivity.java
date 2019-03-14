package com.ekoapp.ekoplayground.presentation.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.ekoapp.ekoplayground.presentation.activities.adapters.ChatAdapter;
import com.ekoapp.ekoplayground.presentation.contracts.ChatContract;
import com.ekoapp.ekoplayground.presentation.presenters.ChatPresenter;
import com.ekoapp.ekoplayground.presentation.viewmodels.ChatViewModel;
import com.uber.autodispose.ScopeProvider;

import butterknife.BindView;

public class ChatActivity extends EkoActivity implements ChatContract {

    @BindView(R2.id.chat_recycler_view)
    RecyclerView chatList;

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ChatViewModel viewModel = ViewModelProviders.of(this).get(ChatViewModel.class);
        ChatPresenter presenter = new ChatPresenter(viewModel, this);
        presenter.test(null);
    }

    @Override
    public ScopeProvider getScopeProvider() {
        return this;
    }

    @Override
    public void setupList() {
        adapter = new ChatAdapter(this);
        chatList.setAdapter(adapter);
        chatList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void submitList(PagedList<Chat> list) {
        adapter.submitList(list);
    }
}
