package com.ekoapp.ekoplayground.room.converters;

import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;

public class DateTimeConverter {

    @TypeConverter
    public static DateTime toDateTime(long millis) {
        return new DateTime(millis);
    }

    @TypeConverter
    public static long fromDateTime(DateTime dateTime) {
        return dateTime.getMillis();
    }
}
