package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.MessageRepository;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Message;
import com.ekoapp.ekoplayground.usecases.MessageGetPagedListRequest;
import com.ekoapp.ekoplayground.usecases.MessageGetPagedListUseCase;

import io.reactivex.Flowable;

public class MessageViewModel extends EkoListViewModel<Message> {

    public MessageViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Message>> getPagedList(String id) {
        MessageRepository repository = new MessageRepository(EkoDatabase.get().getMessageDao());
        MessageGetPagedListRequest request = new MessageGetPagedListRequest(id);
        MessageGetPagedListUseCase useCase = new MessageGetPagedListUseCase(repository);
        return useCase.execute(request);
    }
}
