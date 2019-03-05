package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import org.joda.time.DateTime;

public abstract class EkoEntity {

    @NonNull
    private String id;
    @NonNull
    private String data;
    @NonNull
    private DateTime created;
    @NonNull
    private DateTime lastUpdated;

    EkoEntity() {
    }

    @Ignore
    EkoEntity(@NonNull String id, @NonNull String data) {
        this.id = id;
        this.data = data;
        this.created = DateTime.now();
        this.lastUpdated = created;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getData() {
        return data;
    }

    public void setData(@NonNull String data) {
        this.data = data;
    }

    @NonNull
    public DateTime getCreated() {
        return created;
    }

    public void setCreated(@NonNull DateTime created) {
        this.created = created;
    }

    @NonNull
    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(@NonNull DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
