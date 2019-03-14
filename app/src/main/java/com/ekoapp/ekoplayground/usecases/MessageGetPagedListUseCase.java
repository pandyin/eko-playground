package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Message;

import io.reactivex.Flowable;

public class MessageGetPagedListUseCase extends MessageUseCase<MessageGetPagedListRequest, Flowable<PagedList<Message>>> {

    public MessageGetPagedListUseCase(EkoListRepository<Message> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Message>> execute(MessageGetPagedListRequest request) {
        return getRepository().getPagedList(request.getTopicId());
    }
}
