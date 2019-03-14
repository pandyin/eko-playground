package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Topic;

import io.reactivex.Flowable;

public class TopicGetPagedListUseCase extends TopicUseCase<TopicGetPagedListRequest, Flowable<PagedList<Topic>>> {

    public TopicGetPagedListUseCase(EkoListRepository<Topic> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Topic>> execute(TopicGetPagedListRequest request) {
        return getRepository().getPagedList(request.getChatId());
    }
}
