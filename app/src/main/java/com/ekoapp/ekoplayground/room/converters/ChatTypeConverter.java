package com.ekoapp.ekoplayground.room.converters;

import android.arch.persistence.room.TypeConverter;

import com.ekoapp.ekoplayground.models.ChatType;

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
