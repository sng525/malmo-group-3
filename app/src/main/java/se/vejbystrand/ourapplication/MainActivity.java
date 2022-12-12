package se.vejbystrand.ourapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText activity;
    EditText weight;
    EditText set;
    EditText reps;
    EditText date;
    Button btn_add;
    DatabaseHelper db;
    RecyclerView workoutListView;
    ExerciseAdapter adapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = findViewById(R.id.txt_activity);
        weight = findViewById(R.id.num_weight);
        set = findViewById(R.id.num_set);
        reps = findViewById(R.id.num_reps);
        date = findViewById(R.id.date_time);

       // onBtnAddClick();

        /*workoutListView = findViewById(R.id.workout_list_view);
        db = new DatabaseHelper(MainActivity.this);

        adapter = new ExerciseAdapter(MainActivity.this, db.selectAll());

        workoutListView.setAdapter(adapter);
        workoutListView.setLayoutManager(new LinearLayoutManager(this));*/

    }
/*
    private void onBtnAddClick() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exercise exercise;
                try {
                    exercise = new Exercise(-1,
                            activity.getText().toString(),
                            Integer.parseInt(weight.getText().toString()),
                            Integer.parseInt(set.getText().toString()),
                            Integer.parseInt(reps.getText().toString()),
                            date.toString());
                    Toast.makeText(MainActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    exercise = new Exercise(-1, "error", 0, 0, 0, "error");
                    Toast.makeText(MainActivity.this, "Write correct in the lines", Toast.LENGTH_SHORT).show();
                }

                db = new DatabaseHelper(MainActivity.this);
                db.addWorkout(exercise);

            }
        });
    }
*/
    public void onBtnViewClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}
