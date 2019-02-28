package com.ekoapp.ekoplayground.room.converters;

import android.arch.persistence.room.TypeConverter;

import com.ekoapp.ekoplayground.models.MessageType;

public class MessageTypeConverter {

    @TypeConverter
    public static MessageType toType(String name) {
        return MessageType.valueOf(name);
    }

    @TypeConverter
    public static String fromType(MessageType type) {
        return type.name();
    }
}
