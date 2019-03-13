package com.ekoapp.ekoplayground.repositories;

import android.arch.paging.PagedList;
import android.arch.paging.RxPagedListBuilder;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.entities.Message;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class MessageRepository implements EkoRepository<Message> {

    @Override
    public Flowable<PagedList<Message>> getPagedList(String id) {
        int pageSize = 15;

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(pageSize)
                .build();

        MessageDao messageDao = EkoDatabase.get()
                .getMessageDao();

        return new RxPagedListBuilder<>(messageDao.getMessage(id), config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<Message>() {
                    @Override
                    public void onZeroItemsLoaded() {

                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull Message itemAtFront) {

                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull Message itemAtEnd) {

                    }
                }).buildFlowable(BackpressureStrategy.BUFFER);
    }
}
