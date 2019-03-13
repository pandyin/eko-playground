package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.TopicActivity;

public class TopicListIntent extends EkoIntent<TopicActivity> {

    private static final String CHAT_ID = "chat_id";

    public TopicListIntent(@NonNull Context context, @NonNull String chatId) {
        super(context, TopicActivity.class);
        putExtra(CHAT_ID, chatId);
    }

    @NonNull
    public static String getChatId(@NonNull Intent intent) {
        return intent.getStringExtra(CHAT_ID);
    }
}
