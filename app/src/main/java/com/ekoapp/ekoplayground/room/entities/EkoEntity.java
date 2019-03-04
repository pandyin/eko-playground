package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

public abstract class EkoEntity {

    @NonNull
    private String id;

    EkoEntity() {
    }

    @Ignore
    EkoEntity(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
