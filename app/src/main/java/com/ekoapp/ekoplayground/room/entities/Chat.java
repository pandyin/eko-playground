package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;

import com.ekoapp.ekoplayground.models.ChatType;

@Entity
public class Chat extends BaseEntity {

    private String id;
    private ChatType type;
}
