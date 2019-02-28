package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;

import com.ekoapp.ekoplayground.models.MessageType;

@Entity
public class Message extends BaseEntity {

    private String id;
    private MessageType type;
}
