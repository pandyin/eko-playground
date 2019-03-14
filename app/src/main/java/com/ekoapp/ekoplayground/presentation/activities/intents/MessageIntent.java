package com.ekoapp.ekoplayground.presentation.activities.intents;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.presentation.activities.MessageActivity;

public class MessageIntent extends EkoIntent<MessageActivity> {

    private static final String TOPIC_ID = "topic_id";

    public MessageIntent(@NonNull Context context, @NonNull String topicId) {
        super(context, MessageActivity.class);
        putExtra(TOPIC_ID, topicId);
    }

    @NonNull
    public static String getTopicId(@NonNull Intent intent) {
        return intent.getStringExtra(TOPIC_ID);
    }
}
