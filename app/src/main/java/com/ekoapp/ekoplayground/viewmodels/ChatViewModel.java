package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.arch.paging.RxPagedListBuilder;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.requests.ImmutableGetChat;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.google.gson.JsonElement;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class ChatViewModel extends EkoViewModel {

    public ChatViewModel(@NonNull Application application) {
        super(application);
    }

    public Flowable<PagedList<Chat>> getChat() {
        int pageSize = 15;

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(pageSize)
                .build();

        ChatDao chatDao = EkoDatabase.get()
                .getChatDao();

        return new RxPagedListBuilder<>(chatDao.getChat(), config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<Chat>() {
                    @Override
                    public void onZeroItemsLoaded() {
                        EkoSocket.call(ImmutableGetChat.builder()
                                .skip(0)
                                .limit(pageSize)
                                .build())
                                .map(JsonElement::getAsJsonArray)
                                .doOnSuccess(chatDao::insert)
                                .subscribeOn(Schedulers.io())
                                .subscribe();
                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull Chat itemAtFront) {

                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull Chat itemAtEnd) {

                    }
                }).buildFlowable(BackpressureStrategy.BUFFER);
    }
}
