package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.ChatRepository;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.ekoapp.ekoplayground.usecases.ChatGetPagedListUseCase;

import io.reactivex.Flowable;

public class ChatViewModel extends EkoViewModel<Chat> {

    public ChatViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Chat>> getPagedList(String id) {
        return new ChatGetPagedListUseCase(new ChatRepository()).execute(id);
    }
}
