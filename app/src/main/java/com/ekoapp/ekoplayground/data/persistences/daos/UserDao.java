package com.ekoapp.ekoplayground.data.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ekoapp.ekoplayground.data.persistences.entities.User;

import io.reactivex.Maybe;

@Dao
public abstract class UserDao extends EkoDao<User> {

    @Query("select * from user limit 1")
    public abstract Maybe<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertUser(User user);

    @Query("delete from user")
    public abstract void deleteUser();
}
