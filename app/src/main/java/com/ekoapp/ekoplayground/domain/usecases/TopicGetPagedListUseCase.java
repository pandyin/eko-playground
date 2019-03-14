package com.ekoapp.ekoplayground.domain.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.data.persistences.EkoDatabase;
import com.ekoapp.ekoplayground.data.persistences.entities.Topic;
import com.ekoapp.ekoplayground.data.repositories.TopicRepository;
import com.ekoapp.ekoplayground.domain.requests.TopicGetPagedListRequest;

import io.reactivex.Flowable;

public class TopicGetPagedListUseCase extends TopicUseCase<TopicGetPagedListRequest, Flowable<PagedList<Topic>>> {

    public TopicGetPagedListUseCase() {
        super(new TopicRepository(EkoDatabase.get().getTopicDao()));
    }

    @Override
    public Flowable<PagedList<Topic>> execute(TopicGetPagedListRequest request) {
        return getRepository().getPagedList(request.getChatId());
    }
}
