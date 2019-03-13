package com.ekoapp.ekoplayground.usecases;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Topic;

import io.reactivex.Flowable;

public class TopicGetPagedListUseCase extends TopicUseCase<Flowable<PagedList<Topic>>> {

    public TopicGetPagedListUseCase(EkoRepository<Topic> repository) {
        super(repository);
    }

    @Override
    public Flowable<PagedList<Topic>> execute(String id) {
        return repository.getPagedList(id);
    }
}
