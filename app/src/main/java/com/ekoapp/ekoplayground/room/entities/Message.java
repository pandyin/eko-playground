package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.models.MessageType;

@Entity
public class Message extends EkoEntity {

    @NonNull
    private MessageType type;

    public Message(@NonNull String id, @NonNull MessageType type) {
        super(id);
        this.type = type;
    }

    @NonNull
    public MessageType getType() {
        return type;
    }

    public void setType(@NonNull MessageType type) {
        this.type = type;
    }
}
