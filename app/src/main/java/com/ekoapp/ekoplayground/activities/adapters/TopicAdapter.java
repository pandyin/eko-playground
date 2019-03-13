package com.ekoapp.ekoplayground.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.intents.MessageIntent;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicAdapter extends EkoAdapter<Topic> {

    public TopicAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(@NonNull Topic entity) {
        getContext().startActivity(new MessageIntent(getContext(), entity.getId()));
    }
}
