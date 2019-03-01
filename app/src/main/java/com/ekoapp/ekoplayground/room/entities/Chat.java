package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.models.ChatType;

@Entity
public class Chat extends EkoEntity {

    @NonNull
    private ChatType type;

    public Chat(@NonNull String id, @NonNull ChatType type) {
        super(id);
        this.type = type;
    }

    @NonNull
    public ChatType getType() {
        return type;
    }

    public void setType(@NonNull ChatType type) {
        this.type = type;
    }
}
