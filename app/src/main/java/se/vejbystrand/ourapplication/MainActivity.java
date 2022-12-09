package se.vejbystrand.ourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText activity;
    EditText weight;
    EditText set;
    EditText reps;
    EditText date;
    ListView ListViewLog;
    ArrayAdapter arrayAdapter;
    Button btn_view;
    DatabaseHelper db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = findViewById(R.id.txtActivity);
        weight = findViewById(R.id.numWeight);
        set = findViewById(R.id.numSet);
        reps = findViewById(R.id.numRepoa);
        date = findViewById(R.id.dateTime);




    btn_view.setOnClickListener(view -> {
        Exercise exercise;
        try {
            exercise = new Exercise(-1, activity.getText().toString(), Integer.parseInt(weight.getText().toString()), Integer.parseInt(set.getText().toString()), Integer.parseInt(reps.getText().toString()), date.toString());
            Toast.makeText(this, "Sucessfully added", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            exercise = new Exercise(-1, "error", 0, 0, 0, "error");
            Toast.makeText(this, "Write correct in the lines", Toast.LENGTH_SHORT).show();
        }

        db = new DatabaseHelper(MainActivity.this);
        db.addWorkout(exercise);

    });

    }
    public void onBtnAddClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}
