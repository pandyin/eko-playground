package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

@Entity(primaryKeys = "id")
public class User extends EkoEntity {

    @NonNull
    private String token;

    public User() {
    }

    @Ignore
    public User(@NonNull String userId, @NonNull String data, @NonNull String token) {
        super(userId, data);
        this.token = token;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public void setToken(@NonNull String token) {
        this.token = token;
    }
}
