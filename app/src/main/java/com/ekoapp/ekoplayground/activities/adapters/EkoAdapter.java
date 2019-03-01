package com.ekoapp.ekoplayground.activities.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public class EkoAdapter<ENTITY extends EkoEntity> extends PagedListAdapter<ENTITY, EkoViewHolder> {

    public EkoAdapter() {
        super(new EkoItemCallback<>());
    }

    @NonNull
    @Override
    public EkoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        return new EkoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EkoViewHolder holder, int position) {
        ((TextView) holder.itemView.findViewById(android.R.id.text1)).setText(getItem(position).getId());
    }
}
