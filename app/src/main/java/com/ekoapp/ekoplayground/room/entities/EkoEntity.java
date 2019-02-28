package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public abstract class EkoEntity {

    @NonNull
    @PrimaryKey
    private String id;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
