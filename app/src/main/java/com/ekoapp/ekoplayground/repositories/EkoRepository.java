package com.ekoapp.ekoplayground.repositories;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

import io.reactivex.Flowable;

public interface EkoRepository<ENTITY extends EkoEntity> {

    Flowable<PagedList<ENTITY>> getPagedList(String id);
}
