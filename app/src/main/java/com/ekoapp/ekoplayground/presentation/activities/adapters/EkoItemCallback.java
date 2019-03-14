package com.ekoapp.ekoplayground.presentation.activities.adapters;

import android.support.v7.util.DiffUtil;

import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;
import com.google.common.base.Objects;

public class EkoItemCallback<ENTITY extends EkoEntity> extends DiffUtil.ItemCallback<ENTITY> {

    @Override
    public boolean areItemsTheSame(ENTITY oldItem, ENTITY newItem) {
        return Objects.equal(oldItem, newItem);
    }

    @Override
    public boolean areContentsTheSame(ENTITY oldItem, ENTITY newItem) {
        return Objects.equal(oldItem, newItem);
    }
}
