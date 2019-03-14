package com.ekoapp.ekoplayground.presentation.contracts;

import android.arch.paging.PagedList;

import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;

public interface EkoListContract<ENTITY extends EkoEntity> extends EkoContract {

    void setupList();

    void submitList(PagedList<ENTITY> list);
}
