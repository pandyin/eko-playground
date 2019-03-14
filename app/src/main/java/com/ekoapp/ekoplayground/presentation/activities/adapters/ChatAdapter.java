package com.ekoapp.ekoplayground.presentation.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.ekoapp.ekoplayground.presentation.activities.intents.TopicIntent;

public class ChatAdapter extends EkoAdapter<Chat> {

    public ChatAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(@NonNull Chat entity) {
        getContext().startActivity(new TopicIntent(getContext(), entity.getId()));
    }
}
