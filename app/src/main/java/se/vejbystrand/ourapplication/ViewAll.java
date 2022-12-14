package se.vejbystrand.ourapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAll extends AppCompatActivity {

    ExerciseRepo db;
    RecyclerView workoutListView;
    ExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recy_view);

        db = ExerciseRepo.getInstance(getApplicationContext());

        // Binding the Adapter to the RecyclerView
        workoutListView = findViewById(R.id.workout_list_view);
        adapter = new ExerciseAdapter(ViewAll.this, db.findAllExercises());
        workoutListView.setAdapter(adapter);
        workoutListView.setLayoutManager(new LinearLayoutManager(ViewAll.this));
    }

}
