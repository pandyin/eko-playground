package com.ekoapp.ekoplayground.activities.adapters;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public abstract class EkoAdapter<ENTITY extends EkoEntity> extends PagedListAdapter<ENTITY, EkoViewHolder> {

    @NonNull
    private final Context context;

    EkoAdapter(@NonNull Context context) {
        super(new EkoItemCallback<>());
        this.context = context;
    }

    @NonNull
    @Override
    public EkoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        return new EkoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EkoViewHolder holder, int position) {
        ((TextView) holder.itemView.findViewById(android.R.id.text1)).setText(getItem(position).getData());
        ((TextView) holder.itemView.findViewById(android.R.id.text1)).setOnClickListener(v -> onItemSelected(getItem(position)));
    }

    abstract void onItemSelected(@NonNull ENTITY entity);

    @NonNull
    Context getContext() {
        return context;
    }
}
