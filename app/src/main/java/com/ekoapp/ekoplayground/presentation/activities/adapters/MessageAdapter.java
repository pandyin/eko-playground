package com.ekoapp.ekoplayground.presentation.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.data.persistences.entities.Message;

public class MessageAdapter extends EkoAdapter<Message> {

    public MessageAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    void onItemSelected(@NonNull Message entity) {

    }
}
