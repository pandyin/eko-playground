package com.ekoapp.ekoplayground.repositories;

import android.arch.paging.PagedList;
import android.arch.paging.RxPagedListBuilder;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public abstract class EkoRepository<ENTITY extends EkoEntity> {

    private EkoDao<ENTITY> dao;

    EkoRepository(EkoDao<ENTITY> dao) {
        this.dao = dao;
    }

    public Flowable<PagedList<ENTITY>> getPagedList(String id) {
        int pageSize = 15;

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(pageSize)
                .build();

        return new RxPagedListBuilder<>(dao.getDataSourceFactory(id), config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<ENTITY>() {
                    @Override
                    public void onZeroItemsLoaded() {

                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull ENTITY itemAtFront) {

                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull ENTITY itemAtEnd) {

                    }
                }).buildFlowable(BackpressureStrategy.BUFFER);
    }
}
