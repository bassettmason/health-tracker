package com.bassett.health_tracker_app;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private DaoAccess daoAccessTest;
    private ExerciseDatabase mDb;

// got this from https://developer.android.com/training/data-storage/room/testing-db
    @Before
    public void createTestDataBase(){
        Context context = ApplicationProvider.getApplicationContext();
        mDb = Room.inMemoryDatabaseBuilder(context, ExerciseDatabase.class).build();
        daoAccessTest = mDb.daoAccess();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();

    }

    @Test
    public void databaseTest() throws Exception {
        assertEquals("0", String.valueOf(mDb.daoAccess().count()));

        Exercise exerciseTest1 = new Exercise("test1", "1", "test1", "test1");
        mDb.daoAccess().insertAll(exerciseTest1);

        mDb.daoAccess().insertAll(new Exercise("test2", "2", "test2", "test2" ));

        assertEquals("2", String.valueOf(mDb.daoAccess().count()));

        mDb.daoAccess().insertAll(new Exercise("test3", "3", "test3", "test3" ));
        assertEquals("3", String.valueOf(mDb.daoAccess().count()));

        Exercise exerciseTestById1 = mDb.daoAccess().getById(1);

        assertEquals(exerciseTest1.toString(), exerciseTestById1.toString());
        assertEquals("test2", mDb.daoAccess().getById(2).title);
        assertEquals("test3", mDb.daoAccess().getById(3).description);
    }
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.bassett.health_tracker_app", appContext.getPackageName());
    }



}
