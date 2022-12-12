package se.vejbystrand.ourapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText activity, weight, set, reps, date;
    DatabaseHelper db;
    Exercise exercise;
    FloatingActionButton btn_add;

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

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(view -> {
            try {
                exercise = new Exercise(0,
                        activity.getText().toString(),
                        Integer.parseInt(weight.getText().toString()),
                        Integer.parseInt(set.getText().toString()),
                        Integer.parseInt(reps.getText().toString()),
                        date.getText().toString());
                Toast.makeText(MainActivity.this, R.string.successful_add, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                exercise = new Exercise(-1, "error", 0, 0, 0, "error");
                Toast.makeText(MainActivity.this, R.string.Error_add, Toast.LENGTH_SHORT).show();
            }

            db = DatabaseHelper.getInstance(getApplicationContext());
            db.addWorkout(exercise);
    });
    }

    public void onBtnViewClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}
