package com.ekoapp.ekoplayground.presentation.viewmodels;

import android.app.Application;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;

import io.reactivex.Flowable;

public abstract class EkoListViewModel<ENTITY extends EkoEntity> extends EkoViewModel {

    EkoListViewModel(@NonNull Application application) {
        super(application);
    }

    public abstract Flowable<PagedList<ENTITY>> getPagedList(String id);
}
