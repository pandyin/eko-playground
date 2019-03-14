package com.ekoapp.ekoplayground.presentation.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Topic;
import com.ekoapp.ekoplayground.presentation.activities.intents.MessageIntent;

public class TopicAdapter extends EkoAdapter<Topic> {

    public TopicAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(@NonNull Topic entity) {
        getContext().startActivity(new MessageIntent(getContext(), entity.getId()));
    }
}
