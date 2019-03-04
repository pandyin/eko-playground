package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = "id",
        foreignKeys = @ForeignKey(entity = Chat.class,
                parentColumns = "id",
                childColumns = "chatId",
                onDelete = CASCADE))
public class Topic extends EkoEntity {

    @NonNull
    private String chatId;

    public Topic() {
    }

    @Ignore
    public Topic(@NonNull String topicId, @NonNull String chatId) {
        super(topicId);
        this.chatId = chatId;
    }

    @NonNull
    public String getChatId() {
        return chatId;
    }

    public void setChatId(@NonNull String chatId) {
        this.chatId = chatId;
    }
}
