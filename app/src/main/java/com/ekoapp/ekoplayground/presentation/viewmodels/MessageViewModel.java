package com.ekoapp.ekoplayground.presentation.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Message;
import com.ekoapp.ekoplayground.domain.requests.MessageGetPagedListRequest;
import com.ekoapp.ekoplayground.domain.usecases.MessageGetPagedListUseCase;

import io.reactivex.Flowable;

public class MessageViewModel extends EkoListViewModel<Message> {

    public MessageViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Message>> getPagedList(String id) {
        MessageGetPagedListRequest request = new MessageGetPagedListRequest(id);
        MessageGetPagedListUseCase useCase = new MessageGetPagedListUseCase();
        return useCase.execute(request);
    }
}
