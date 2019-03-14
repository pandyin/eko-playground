package com.ekoapp.ekoplayground.contract;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public interface EkoListContract<ENTITY extends EkoEntity> extends EkoContract {

    void setupList();

    void submitList(PagedList<ENTITY> list);
}
