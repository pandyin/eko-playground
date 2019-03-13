package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

import io.reactivex.Flowable;

public abstract class EkoViewModel<ENTITY extends EkoEntity> extends AndroidViewModel {

    EkoViewModel(@NonNull Application application) {
        super(application);
    }

    public abstract Flowable<PagedList<ENTITY>> getPagedList(String id);
}
