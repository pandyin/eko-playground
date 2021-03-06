package com.ekoapp.ekoplayground.presentation.activities.intents;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.presentation.activities.TopicActivity;

public class TopicIntent extends EkoIntent<TopicActivity> {

    private static final String CHAT_ID = "chat_id";

    public TopicIntent(@NonNull Context context, @NonNull String chatId) {
        super(context, TopicActivity.class);
        putExtra(CHAT_ID, chatId);
    }

    @NonNull
    public static String getChatId(@NonNull Intent intent) {
        return intent.getStringExtra(CHAT_ID);
    }
}
