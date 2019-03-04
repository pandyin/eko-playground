package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.MessageListActivity;

public class MessageListIntent extends EkoIntent<MessageListActivity> {

    private static final String TOPIC_ID = "topic_id";

    public MessageListIntent(@NonNull Context context, @NonNull String topicId) {
        super(context, MessageListActivity.class);
        putExtra(TOPIC_ID, topicId);
    }

    @NonNull
    public static String getTopicId(@NonNull Intent intent) {
        return intent.getStringExtra(TOPIC_ID);
    }
}
