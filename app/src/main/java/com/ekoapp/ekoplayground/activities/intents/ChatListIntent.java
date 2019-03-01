package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;

import com.ekoapp.ekoplayground.activities.ChatListActivity;

public class ChatListIntent extends EkoIntent {

    public ChatListIntent(Context context) {
        super(context, ChatListActivity.class);
    }
}
