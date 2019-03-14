package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.TopicRepository;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Topic;
import com.ekoapp.ekoplayground.usecases.TopicGetPagedListRequest;
import com.ekoapp.ekoplayground.usecases.TopicGetPagedListUseCase;

import io.reactivex.Flowable;

public class TopicViewModel extends EkoListViewModel<Topic> {

    public TopicViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Topic>> getPagedList(String id) {
        TopicRepository repository = new TopicRepository(EkoDatabase.get().getTopicDao());
        TopicGetPagedListRequest request = new TopicGetPagedListRequest(id);
        TopicGetPagedListUseCase useCase = new TopicGetPagedListUseCase(repository);
        return useCase.execute(request);
    }
}
