package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.models.ChatType;

@Entity(primaryKeys = "id")
public class Chat extends EkoEntity {

    @NonNull
    private ChatType type;

    public Chat() {
    }

    @Ignore
    public Chat(@NonNull String chatId, @NonNull ChatType type) {
        super(chatId);
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
