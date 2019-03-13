package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;

import com.ekoapp.ekoplayground.activities.ChatActivity;

public class ChatListIntent extends EkoIntent<ChatActivity> {

    public ChatListIntent(Context context) {
        super(context, ChatActivity.class);
    }
}
