package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;

import com.ekoapp.ekoplayground.activities.ChatActivity;

public class ChatIntent extends EkoIntent<ChatActivity> {

    public ChatIntent(Context context) {
        super(context, ChatActivity.class);
    }
}
