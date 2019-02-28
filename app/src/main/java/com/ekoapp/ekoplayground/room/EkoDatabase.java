package com.ekoapp.ekoplayground.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.ekoapp.ekoplayground.room.converters.ChatTypeConverter;
import com.ekoapp.ekoplayground.room.converters.MessageTypeConverter;
import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.ekoapp.ekoplayground.room.entities.Message;


@Database(version = 1, entities = {Chat.class, Message.class})
@TypeConverters({ChatTypeConverter.class, MessageTypeConverter.class})
public abstract class EkoDatabase extends RoomDatabase {

    private static volatile EkoDatabase INSTANCE;

    public static synchronized EkoDatabase init(Context context) {
        INSTANCE = Room.inMemoryDatabaseBuilder(context, EkoDatabase.class).build();
        return INSTANCE;
    }

    public static EkoDatabase get() {
        return INSTANCE;
    }

    public abstract ChatDao getChatDao();

    public abstract MessageDao getMessageDao();
}
