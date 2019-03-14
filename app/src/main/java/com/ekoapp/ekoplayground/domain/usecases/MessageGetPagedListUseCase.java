package com.ekoapp.ekoplayground.domain.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.data.persistences.EkoDatabase;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;
import com.ekoapp.ekoplayground.data.repositories.MessageRepository;
import com.ekoapp.ekoplayground.domain.requests.MessageGetPagedListRequest;

import io.reactivex.Flowable;

public class MessageGetPagedListUseCase extends MessageUseCase<MessageGetPagedListRequest, Flowable<PagedList<Message>>> {

    public MessageGetPagedListUseCase() {
        super(new MessageRepository(EkoDatabase.get().getMessageDao()));
    }

    @Override
    public Flowable<PagedList<Message>> execute(MessageGetPagedListRequest request) {
        return getRepository().getPagedList(request.getTopicId());
    }
}
