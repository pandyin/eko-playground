package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;

import com.ekoapp.ekoplayground.activities.MessageListActivity;

public class MessageListIntent extends EkoIntent<MessageListActivity> {

    public MessageListIntent(Context context) {
        super(context, MessageListActivity.class);
    }
}
