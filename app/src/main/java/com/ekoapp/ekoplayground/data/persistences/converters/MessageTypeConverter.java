package com.ekoapp.ekoplayground.data.persistences.converters;

import android.arch.persistence.room.TypeConverter;

import com.ekoapp.ekoplayground.common.models.MessageType;

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
