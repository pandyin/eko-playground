package com.ekoapp.ekoplayground.contract;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;
import com.uber.autodispose.ScopeProvider;

public interface EkoContract<ENTITY extends EkoEntity> {

    ScopeProvider getScopeProvider();

    void setupList();

    void submitList(PagedList<ENTITY> list);
}
