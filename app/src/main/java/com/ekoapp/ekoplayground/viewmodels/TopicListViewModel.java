package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.arch.paging.RxPagedListBuilder;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.requests.ImmutableGetTopic;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.TopicDao;
import com.ekoapp.ekoplayground.room.entities.Topic;
import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.google.gson.JsonElement;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class TopicListViewModel extends EkoViewModel {

    public TopicListViewModel(@NonNull Application application) {
        super(application);
    }

    public Flowable<PagedList<Topic>> getTopic(String chatId) {
        int pageSize = 15;

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(pageSize)
                .build();

        TopicDao topicDao = EkoDatabase.get()
                .getTopicDao();

        return new RxPagedListBuilder<>(topicDao.getTopic(chatId), config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<Topic>() {
                    @Override
                    public void onZeroItemsLoaded() {
                        EkoSocket.call(ImmutableGetTopic.builder()
                                .chatId(chatId)
                                .skip(0)
                                .limit(pageSize)
                                .build())
                                .map(JsonElement::getAsJsonArray)
                                .doOnSuccess(topicDao::insert)
                                .subscribeOn(Schedulers.io())
                                .subscribe();
                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull Topic itemAtFront) {

                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull Topic itemAtEnd) {

                    }
                }).buildFlowable(BackpressureStrategy.BUFFER);
    }
}
