package com.bassett.health_tracker_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//from https://github.com/anitaa1990/RoomDb-Sample/tree/master/app/src/main
@Database(entities = {Exercise.class}, version = 3, exportSchema = false)
public abstract class ExerciseDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}
