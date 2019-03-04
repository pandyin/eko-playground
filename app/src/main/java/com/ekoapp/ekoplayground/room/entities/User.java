package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity
public class User extends EkoEntity {

    @NonNull
    private String token;

    public User(@NonNull String token) {
        super(UUID.randomUUID().toString());
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
