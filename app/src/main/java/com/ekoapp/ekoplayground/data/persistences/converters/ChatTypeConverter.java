package com.ekoapp.ekoplayground.data.persistences.converters;

import android.arch.persistence.room.TypeConverter;

import com.ekoapp.ekoplayground.common.models.ChatType;

public class ChatTypeConverter {

    @TypeConverter
    public static ChatType toType(String name) {
        return ChatType.valueOf(name);
    }

    @TypeConverter
    public static String fromType(ChatType type) {
        return type.name();
    }
}
