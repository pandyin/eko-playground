package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;

import java.util.UUID;

@Entity
public class User extends EkoEntity {

    public User() {
        super(UUID.randomUUID().toString());
    }
}
