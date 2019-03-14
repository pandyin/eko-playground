package com.ekoapp.ekoplayground.presentation.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.ekoapp.ekoplayground.domain.requests.ChatGetPagedListRequest;
import com.ekoapp.ekoplayground.domain.usecases.ChatGetPagedListUseCase;

import io.reactivex.Flowable;

public class ChatViewModel extends EkoListViewModel<Chat> {

    public ChatViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Chat>> getPagedList(String id) {
        ChatGetPagedListRequest request = new ChatGetPagedListRequest();
        ChatGetPagedListUseCase useCase = new ChatGetPagedListUseCase();
        return useCase.execute(request);
    }
}
