package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Message;

import io.reactivex.Flowable;

public class MessageGetPagedListUseCase extends MessageUseCase<Flowable<PagedList<Message>>> {

    public MessageGetPagedListUseCase(EkoRepository<Message> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Message>> execute(String id) {
        return repository.getPagedList(id);
    }
}
