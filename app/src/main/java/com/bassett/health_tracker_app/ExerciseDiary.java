package com.bassett.health_tracker_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.room.Room;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.EditText;

import java.util.Date;

public class ExerciseDiary extends AppCompatActivity {
    // from Zahra code review and         //source: https://medium.com/@guendouz/room-livedata-and-recyclerview-d8e96fb31dfe





    private static Exercise exercise;
    private static ExerciseDatabase appDatabase;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_diary);

        appDatabase = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class, "exercise").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();


        recyclerView = findViewById(R.id.diaryRecycler);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new MyAdapter(appDatabase.daoAccess().getAllExercise());
        recyclerView.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();


    }


    public void addDiaryEntryOnButtonClick(View view){

        //finding the EditTextby ID:
        EditText editTitle = findViewById(R.id.title);
        EditText editQuantity = findViewById(R.id.quantity);
        EditText editDescription=findViewById(R.id.description);
        String timestamp = new Date().toString();



        // fetch data and create Exercise object
        Exercise exercise = new Exercise(editTitle.getText().toString(), editQuantity.getText().toString(), editDescription.getText().toString(), timestamp);
        appDatabase.daoAccess().insertAll(exercise);



        finish();
        startActivity(getIntent());
        mAdapter.notifyDataSetChanged();
    }

}