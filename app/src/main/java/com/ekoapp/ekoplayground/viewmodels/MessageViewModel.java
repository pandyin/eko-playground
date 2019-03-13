package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.MessageRepository;
import com.ekoapp.ekoplayground.room.entities.Message;
import com.ekoapp.ekoplayground.usecases.MessageGetPagedListUseCase;

import io.reactivex.Flowable;

public class MessageViewModel extends EkoViewModel {

    private final MessageGetPagedListUseCase useCase;

    public MessageViewModel(@NonNull Application application) {
        super(application);
        useCase = new MessageGetPagedListUseCase(new MessageRepository());
    }

    public Flowable<PagedList<Message>> getMessage(String topicId) {
        return useCase.execute(topicId);
    }
}
