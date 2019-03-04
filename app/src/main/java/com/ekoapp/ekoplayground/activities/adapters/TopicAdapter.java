package com.ekoapp.ekoplayground.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.intents.MessageListIntent;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicAdapter extends EkoAdapter<Topic> {

    public TopicAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(Topic entity) {
        getContext().startActivity(new MessageListIntent(getContext(), entity.getId()));
    }
}
