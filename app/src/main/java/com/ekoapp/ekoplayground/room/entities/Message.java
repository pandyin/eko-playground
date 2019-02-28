package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.models.MessageType;

@Entity
public class Message extends BaseEntity {

    @NonNull
    private MessageType type;

    @NonNull
    public MessageType getType() {
        return type;
    }

    public void setType(@NonNull MessageType type) {
        this.type = type;
    }
}
