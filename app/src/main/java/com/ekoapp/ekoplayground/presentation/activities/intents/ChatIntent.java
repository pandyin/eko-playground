package com.ekoapp.ekoplayground.presentation.activities.intents;

import android.content.Context;

import com.ekoapp.ekoplayground.presentation.activities.ChatActivity;

public class ChatIntent extends EkoIntent<ChatActivity> {

    public ChatIntent(Context context) {
        super(context, ChatActivity.class);
    }
}
