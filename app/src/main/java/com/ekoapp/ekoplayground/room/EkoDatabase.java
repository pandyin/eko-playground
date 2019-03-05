package com.ekoapp.ekoplayground.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.ekoapp.ekoplayground.room.converters.ChatTypeConverter;
import com.ekoapp.ekoplayground.room.converters.DateTimeConverter;
import com.ekoapp.ekoplayground.room.converters.MessageTypeConverter;
import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.daos.TopicDao;
import com.ekoapp.ekoplayground.room.daos.UserDao;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.ekoapp.ekoplayground.room.entities.Message;
import com.ekoapp.ekoplayground.room.entities.Topic;
import com.ekoapp.ekoplayground.room.entities.User;


@Database(version = 1, entities = {Chat.class, Message.class, Topic.class, User.class}, exportSchema = false)
@TypeConverters({ChatTypeConverter.class, DateTimeConverter.class, MessageTypeConverter.class})
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

    public abstract TopicDao getTopicDao();

    public abstract UserDao getUserDao();
}
