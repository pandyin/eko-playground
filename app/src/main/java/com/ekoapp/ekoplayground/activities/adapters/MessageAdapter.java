package com.ekoapp.ekoplayground.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageAdapter extends EkoAdapter<Message> {

    public MessageAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(Message entity) {

    }
}
