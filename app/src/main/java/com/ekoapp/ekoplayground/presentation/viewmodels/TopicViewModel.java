package com.ekoapp.ekoplayground.presentation.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Topic;
import com.ekoapp.ekoplayground.domain.requests.TopicGetPagedListRequest;
import com.ekoapp.ekoplayground.domain.usecases.TopicGetPagedListUseCase;

import io.reactivex.Flowable;

public class TopicViewModel extends EkoListViewModel<Topic> {

    public TopicViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public Flowable<PagedList<Topic>> getPagedList(String id) {
        TopicGetPagedListRequest request = new TopicGetPagedListRequest(id);
        TopicGetPagedListUseCase useCase = new TopicGetPagedListUseCase();
        return useCase.execute(request);
    }
}
