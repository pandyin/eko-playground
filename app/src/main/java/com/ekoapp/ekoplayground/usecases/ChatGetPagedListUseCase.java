package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Chat;

import io.reactivex.Flowable;

public class ChatGetPagedListUseCase extends ChatUseCase<ChatGetPagedListRequest, Flowable<PagedList<Chat>>> {

    public ChatGetPagedListUseCase(EkoListRepository<Chat> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Chat>> execute(ChatGetPagedListRequest request) {
        return getRepository().getPagedList(null);
    }
}
