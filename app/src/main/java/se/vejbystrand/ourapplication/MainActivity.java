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




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logview);

        activity = findViewById(R.id.txtActivityp2);
        weight = findViewById(R.id.numWeight3);
        set = findViewById(R.id.numSet3);
        reps = findViewById(R.id.numRepoa3);
        date = findViewById(R.id.dateTime3);




    btn_view.setOnClickListener(view -> {
        Exercise exercise;
        try {
            exercise = new Exercise(-1, activity.getText().toString(), Integer.parseInt(weight.getText().toString()), Integer.parseInt(set.getText().toString()), Integer.parseInt(reps.getText().toString()), date.getText());
            Toast.makeText(this, "Sucessfully added", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            exercise = new Exercise(-1, "error", 0, 0, 0, "error");
            Toast.makeText(this, "Write correct in the lines", Toast.LENGTH_SHORT).show();
        }
    });

    }
    public void onBtnAddClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }

}
