package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.ChatRepository;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.ekoapp.ekoplayground.usecases.ChatGetPagedListRequest;
import com.ekoapp.ekoplayground.usecases.ChatGetPagedListUseCase;

import io.reactivex.Flowable;

public class ChatViewModel extends EkoListViewModel<Chat> {

    public ChatViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Chat>> getPagedList(String id) {
        ChatRepository repository = new ChatRepository(EkoDatabase.get().getChatDao());
        ChatGetPagedListRequest request = new ChatGetPagedListRequest();
        ChatGetPagedListUseCase useCase = new ChatGetPagedListUseCase(repository);
        return useCase.execute(request);
    }
}
