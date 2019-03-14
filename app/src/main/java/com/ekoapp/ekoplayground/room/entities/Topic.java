package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import org.joda.time.DateTime;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = "id",
        foreignKeys = @ForeignKey(entity = Chat.class,
                parentColumns = "id",
                childColumns = "chatId",
                onDelete = CASCADE))
public class Topic extends EkoEntity {

    @NonNull
    private String chatId;

    @NonNull
    private DateTime lastActivity;

    public Topic() {
    }

    @Ignore
    public Topic(@NonNull String id, @NonNull String data, @NonNull String chatId, @NonNull DateTime lastActivity) {
        super(id, data);
        this.chatId = chatId;
        this.lastActivity = lastActivity;
    }

    @NonNull
    public String getChatId() {
        return chatId;
    }

    public void setChatId(@NonNull String chatId) {
        this.chatId = chatId;
    }

    @NonNull
    public DateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(@NonNull DateTime lastActivity) {
        this.lastActivity = lastActivity;
    }
}
