package com.ekoapp.ekoplayground.data.persistences.entities;

import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

public abstract class EkoEntity {

    @NonNull
    private String id;
    @NonNull
    private String data;

    EkoEntity() {
    }

    @Ignore
    EkoEntity(@NonNull String id, @NonNull String data) {
        this.id = id;
        this.data = data;
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
}
