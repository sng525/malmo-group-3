package se.vejbystrand.ourapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText activity, weight, set, reps, date;
    ExerciseRepo db;
    Exercise exercise;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnAdd(View view) {
        activity = findViewById(R.id.txt_activity);
        weight = findViewById(R.id.num_weight);
        set = findViewById(R.id.num_set);
        reps = findViewById(R.id.num_reps);
        date = findViewById(R.id.date_time);

        String activityString = activity.getText().toString();
        String setString = set.getText().toString();
        String repsString = reps.getText().toString();
        String dateString = date.getText().toString();
        String weightString = weight.getText().toString();


        if (activityString.length() == 0 || setString.length() == 0 || repsString.length() == 0 || dateString.length() == 0 || weightString.length() == 0) {
            Toast.makeText(MainActivity.this, R.string.Error_add, Toast.LENGTH_SHORT).show();
            return;
        } else {
            int weightInt = Integer.parseInt(weightString);
            int setInt = Integer.parseInt(setString);
            int repsInt = Integer.parseInt(repsString);

            exercise = new Exercise(0, activityString, weightInt, setInt, repsInt, dateString);

            Toast.makeText(MainActivity.this, R.string.successful_add, Toast.LENGTH_SHORT).show();
        }

        db = ExerciseRepo.getInstance(getApplicationContext());
        db.save(exercise);
    }

    public void onBtnViewClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}
