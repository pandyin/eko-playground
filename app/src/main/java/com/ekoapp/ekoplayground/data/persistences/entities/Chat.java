package com.ekoapp.ekoplayground.data.persistences.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.common.models.ChatType;

import org.joda.time.DateTime;

@Entity(primaryKeys = "id")
public class Chat extends EkoEntity {

    @NonNull
    private ChatType type;

    private DateTime lastActivity;

    public Chat() {
    }

    @Ignore
    public Chat(@NonNull String id, @NonNull String data, @NonNull ChatType type, DateTime lastActivity) {
        super(id, data);
        this.type = type;
        this.lastActivity = lastActivity;
    }

    @NonNull
    public ChatType getType() {
        return type;
    }

    public void setType(@NonNull ChatType type) {
        this.type = type;
    }

    public DateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(DateTime lastActivity) {
        this.lastActivity = lastActivity;
    }
}
