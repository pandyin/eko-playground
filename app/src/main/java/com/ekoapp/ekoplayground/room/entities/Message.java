package com.ekoapp.ekoplayground.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.models.MessageType;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = "id",
        foreignKeys = @ForeignKey(entity = Topic.class,
                parentColumns = "id",
                childColumns = "topicId",
                onDelete = CASCADE))
public class Message extends EkoEntity {

    @NonNull
    private String topicId;

    @NonNull
    private MessageType type;

    public Message() {
    }

    @Ignore
    public Message(@NonNull String messageId, @NonNull String topicId, @NonNull MessageType type) {
        super(messageId);
        this.topicId = topicId;
        this.type = type;
    }

    @NonNull
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(@NonNull String topicId) {
        this.topicId = topicId;
    }

    @NonNull
    public MessageType getType() {
        return type;
    }

    public void setType(@NonNull MessageType type) {
        this.type = type;
    }
}
