package com.bassett.health_tracker_app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
//from https://github.com/anitaa1990/RoomDb-Sample/tree/master/app/src/main
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}
