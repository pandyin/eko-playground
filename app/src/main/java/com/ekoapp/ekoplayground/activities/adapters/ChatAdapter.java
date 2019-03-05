package com.ekoapp.ekoplayground.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.intents.TopicListIntent;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatAdapter extends EkoAdapter<Chat> {

    public ChatAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(@NonNull Chat entity) {
        getContext().startActivity(new TopicListIntent(getContext(), entity.getId()));
    }
}
