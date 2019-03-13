package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Chat;

import io.reactivex.Flowable;

public class ChatGetPagedListUseCase extends ChatUseCase<Flowable<PagedList<Chat>>> {

    public ChatGetPagedListUseCase(EkoRepository<Chat> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Chat>> execute(String id) {
        return repository.getPagedList(id);
    }
}
