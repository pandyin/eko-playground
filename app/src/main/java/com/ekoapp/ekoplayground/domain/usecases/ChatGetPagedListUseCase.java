package com.ekoapp.ekoplayground.domain.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.data.persistences.EkoDatabase;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.ekoapp.ekoplayground.data.repositories.ChatRepository;
import com.ekoapp.ekoplayground.domain.requests.ChatGetPagedListRequest;

import io.reactivex.Flowable;

public class ChatGetPagedListUseCase extends ChatUseCase<ChatGetPagedListRequest, Flowable<PagedList<Chat>>> {

    public ChatGetPagedListUseCase() {
        super(new ChatRepository(EkoDatabase.get().getChatDao()));
    }

    @Override
    public Flowable<PagedList<Chat>> execute(ChatGetPagedListRequest request) {
        return getRepository().getPagedList(null);
    }
}
