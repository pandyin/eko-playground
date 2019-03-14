package com.ekoapp.ekoplayground.data.repositories;

import android.arch.paging.PagedList;
import android.arch.paging.RxPagedListBuilder;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.datasources.local.EkoListLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.EkoListRemoteDataStore;
import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public abstract class EkoListRepository<ENTITY extends EkoEntity> extends EkoRepository<EkoListLocalDataStore<ENTITY>, EkoListRemoteDataStore<ENTITY>> {

    EkoListRepository(EkoListLocalDataStore<ENTITY> entityLocalDataStore, EkoListRemoteDataStore<ENTITY> entityListRemoteDataStore) {
        super(entityLocalDataStore, entityListRemoteDataStore);
    }

    public Flowable<PagedList<ENTITY>> getPagedList(String id) {
        int pageSize = 15;

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(pageSize)
                .build();

        return new RxPagedListBuilder<>(getLocal().getFactory(id), config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<ENTITY>() {
                    @Override
                    public void onZeroItemsLoaded() {
                        getRemote().getFirstPage(id);
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
